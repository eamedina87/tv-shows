package tech.medina.tvshows.ui.tvshows.list.adapter

import androidx.recyclerview.widget.DiffUtil
import tech.medina.tvshows.domain.model.Show

class ShowDiffCallback: DiffUtil.ItemCallback<Show>() {

    override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
        return oldItem == newItem
    }

}