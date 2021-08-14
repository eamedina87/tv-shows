package tech.medina.tvshows.ui.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface IImageLoader {
    fun loadWithUrl(url: String?, targetView: ImageView, placeholder: Int = 0)
}

class ImageLoader @Inject constructor(
    @ApplicationContext private val context: Context
) : IImageLoader {

    private val glide by lazy {
        Glide.with(context)
    }

    override fun loadWithUrl(url: String?, targetView: ImageView, placeholder: Int) {
        glide.load(url)
            .placeholder(placeholder)
            .into(targetView)
    }

}