package tech.medina.tvshows.ui.tvshows.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import tech.medina.tvshows.databinding.ItemTvShowListBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.ImageLoader

class ShowListPagingAdapter(
    private val imageLoader: ImageLoader
) : PagingDataAdapter<Show, ShowViewHolder>(ShowDiffCallback()) {

    companion object {

        fun create(imageLoader: ImageLoader) : ShowListPagingAdapter =
            ShowListPagingAdapter(imageLoader)

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
        return ShowViewHolder.create(imageLoader, binding)
    }

}