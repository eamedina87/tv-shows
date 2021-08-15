package tech.medina.tvshows.ui.tvshows.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import tech.medina.tvshows.databinding.ItemTvShowListBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.IImageLoader

class ShowListPagingAdapter(
    private val imageLoader: IImageLoader,
    private val onItemClickFunction: (Show) -> Unit
) : PagingDataAdapter<Show, ShowViewHolder>(ShowDiffCallback()) {

    companion object {

        fun create(
            imageLoader: IImageLoader,
            onItemClickFunction: (Show) -> Unit
        ): ShowListPagingAdapter =
            ShowListPagingAdapter(imageLoader, onItemClickFunction)

    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = ItemTvShowListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShowViewHolder.create(imageLoader, binding, onItemClickFunction)
    }

}