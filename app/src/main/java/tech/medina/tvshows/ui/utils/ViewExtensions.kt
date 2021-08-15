package tech.medina.tvshows.ui.utils

import android.view.View

fun View.visible(show: Boolean = true) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}