package tech.medina.tvshows.ui.tvshows.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tech.medina.tvshows.databinding.FragmentShowsListBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.BaseFragment
import tech.medina.tvshows.ui.tvshows.ShowsViewModel
import tech.medina.tvshows.ui.tvshows.list.adapter.ShowListPagingAdapter
import tech.medina.tvshows.ui.tvshows.list.adapter.ShowsLoadStateAdapter
import tech.medina.tvshows.ui.utils.visible

class ShowsListFragment: BaseFragment() {

    override val viewModel by viewModels<ShowsViewModel>()
    private var _binding: FragmentShowsListBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.

    private val adapter by lazy {
        ShowListPagingAdapter.create(imageLoader) { selectedShow ->
            goToDetail(selectedShow)
        }
    }

    private val navController by lazy {
        findNavController()
    }

    override fun getBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentShowsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        showLoader()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getShowsList().collectLatest {
                onGetShowListSuccess(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onGetShowListSuccess(pagingData: PagingData<Show>) {
        if (binding.recyclerView.adapter == null) {
            binding.recyclerView.adapter =
                adapter.withLoadStateFooter(ShowsLoadStateAdapter.create { adapter.retry() })
        }
        viewLifecycleOwner.lifecycleScope.launch {
            adapter.submitData(pagingData)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadState ->
                if (loadState.refresh !is LoadState.Loading) showLoader(false)
                if (loadState.refresh is LoadState.Error) {
                    onGetShowListError((loadState.refresh as LoadState.Error).error)
                }
            }
        }
    }

    private fun onGetShowListError(error: Throwable) {
        showMessage(error.message ?: "An error ocurred.")
    }

    private fun goToDetail(show: Show) {
        navController.navigate(ShowsListFragmentDirections.actionShowListToDetail(show.id))
    }

    private fun showLoader(show: Boolean = true) {
        binding.progress.visible(show)
    }

}