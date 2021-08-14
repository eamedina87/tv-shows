package tech.medina.tvshows.ui.tvshows.list.adapter

import androidx.recyclerview.widget.RecyclerView
import tech.medina.tvshows.databinding.ItemTvShowListBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.ImageLoader

class ShowViewHolder(
    private val imageLoader: ImageLoader,
    private val binding: ItemTvShowListBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun create(imageLoader: ImageLoader, binding: ItemTvShowListBinding) : ShowViewHolder =
            ShowViewHolder(imageLoader, binding)

    }

    fun bind(data: Show) {
        imageLoader.loadWithUrl(data.imageOriginal, binding.image)
    }

}