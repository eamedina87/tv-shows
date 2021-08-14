package tech.medina.tvshows.ui.tvshows.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import tech.medina.tvshows.databinding.FragmentShowDetailBinding
import tech.medina.tvshows.ui.common.BaseFragment
import tech.medina.tvshows.ui.tvshows.ShowsViewModel

class ShowDetailFragment: BaseFragment() {

    override val viewModel by viewModels<ShowsViewModel>()
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}