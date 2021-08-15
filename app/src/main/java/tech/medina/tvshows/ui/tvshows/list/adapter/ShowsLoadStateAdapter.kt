package tech.medina.tvshows.ui.tvshows.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import tech.medina.tvshows.databinding.ItemContentLoaderBinding

/***
 * This adapter is in charge of displaying the loader or error message at the bottom of the recyclerview
 * when the pagination library is loading a new page or an error has ocurred while doing it.
 */

class ShowsLoadStateAdapter(
    private val retryFunction: (() -> Unit)?
) : LoadStateAdapter<ShowLoadStateViewHolder>() {

    companion object {
        fun create(retryFunction: (() -> Unit)?) = ShowsLoadStateAdapter(retryFunction)
    }

    override fun onBindViewHolder(holder: ShowLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState, retryFunction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ShowLoadStateViewHolder {
        val binding = ItemContentLoaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowLoadStateViewHolder.create(binding)
    }

}


