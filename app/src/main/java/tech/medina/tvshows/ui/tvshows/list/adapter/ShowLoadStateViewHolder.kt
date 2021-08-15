package tech.medina.tvshows.ui.tvshows.list.adapter

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import tech.medina.tvshows.databinding.ItemContentLoaderBinding
import tech.medina.tvshows.ui.utils.visible

/**
 * This ViewHolder controls the pagination loader and shows a progress indicator, an error message
 * or a retry button, depending if the loading of a new page has succeeded or failed.
 * A retry function should be provided to assign an action to the retry button.
 */

class ShowLoadStateViewHolder(
    private val binding: ItemContentLoaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(binding: ItemContentLoaderBinding) = ShowLoadStateViewHolder(binding)
    }

    fun bind(loadState: LoadState, retryFunction: (() -> Unit)?) {
        binding.progress.visible(loadState is LoadState.Loading)
        binding.error.apply {
            visible(loadState is LoadState.Error)
            if (loadState is LoadState.Error) {
                text = loadState.error.localizedMessage
            }
        }
        binding.button.apply {
            visible(loadState is LoadState.Error)
            setOnClickListener {
                retryFunction?.invoke()
            }
        }
    }

}