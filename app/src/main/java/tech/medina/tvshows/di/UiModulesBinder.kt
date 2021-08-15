package tech.medina.tvshows.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import tech.medina.tvshows.domain.usecase.GetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.GetShowListUseCase
import tech.medina.tvshows.domain.usecase.IGetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.IGetShowListUseCase
import tech.medina.tvshows.ui.common.IImageLoader
import tech.medina.tvshows.ui.common.ImageLoader

@InstallIn(ActivityComponent::class)
@Module
abstract class UiModulesBinder {

    @Binds
    abstract fun bindImageLoader(
        imageLoader: ImageLoader
    ): IImageLoader

}