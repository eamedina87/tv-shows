package tech.medina.tvshows.ui.tvshows.list.adapter

import androidx.recyclerview.widget.RecyclerView
import tech.medina.tvshows.databinding.ItemTvShowListBinding
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.ui.common.IImageLoader

class ShowViewHolder(
    private val imageLoader: IImageLoader,
    private val binding: ItemTvShowListBinding,
    private val onItemClickFunction: (Show) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun create(
            imageLoader: IImageLoader,
            binding: ItemTvShowListBinding,
            onItemClickFunction: (Show) -> Unit
        ) : ShowViewHolder =
            ShowViewHolder(imageLoader, binding, onItemClickFunction)

    }

    fun bind(data: Show) {
        imageLoader.loadWithUrl(data.imageOriginal, binding.image)
        binding.root.setOnClickListener {
            onItemClickFunction(data)
        }
    }

}