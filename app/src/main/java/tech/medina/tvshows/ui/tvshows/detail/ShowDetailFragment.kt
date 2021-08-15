package tech.medina.tvshows.ui.tvshows.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.flow.collectLatest
import tech.medina.tvshows.databinding.FragmentShowDetailBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.BaseFragment
import tech.medina.tvshows.ui.tvshows.ShowsViewModel
import tech.medina.tvshows.ui.utils.runIfNotNull
import tech.medina.tvshows.ui.utils.visible

class ShowDetailFragment: BaseFragment() {

    override val viewModel by viewModels<ShowsViewModel>()
    private val args: ShowDetailFragmentArgs by navArgs()
    private var _binding: FragmentShowDetailBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.

    private val navController by lazy {
        findNavController()
    }

    override fun getBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentShowDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        initCollectors()
        viewModel.getShowDetail(args.showId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initCollectors() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.detail.collectLatest { show ->
                runIfNotNull(show) { onGetShowDetailSuccess(show) }
            }
            viewModel.showLoader.collectLatest { show ->
                runIfNotNull(show) { showLoader(show) }
            }
            viewModel.error.collectLatest { error ->
                runIfNotNull(error) { onGetShowDetailError(error) }
            }
        }
    }

    private fun onGetShowDetailSuccess(data: Show) {
        imageLoader.loadWithUrl(data.imageOriginal, binding.image)
        binding.title.text = data.name
        binding.summary.text = HtmlCompat.fromHtml(data.summary, 0)
        with(binding.rating) {
            visible(data.rating > 0)
            text = data.rating.toString()
        }
    }

    private fun onGetShowDetailError(error: String) {
        showMessage(error)
        navController.popBackStack()
    }

    private fun showLoader(show: Boolean = true) {
        binding.progress.visible(show)
    }
}