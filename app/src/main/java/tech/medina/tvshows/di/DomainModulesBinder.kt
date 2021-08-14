package tech.medina.tvshows.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.medina.tvshows.domain.usecase.GetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.GetShowListUseCase
import tech.medina.tvshows.domain.usecase.IGetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.IGetShowListUseCase

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModulesBinder {

    @Binds
    abstract fun bindGetShowListUseCase(
        useCase: GetShowListUseCase
    ): IGetShowListUseCase

    @Binds
    abstract fun bindGetShowDetailUseCase(
        useCase: GetShowDetailUseCase
    ): IGetShowDetailUseCase

}