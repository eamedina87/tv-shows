package tech.medina.tvshows.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.medina.tvshows.BuildConfig
import tech.medina.tvshows.data.TvMazeService
import tech.medina.tvshows.data.mapper.*
import tech.medina.tvshows.data.tvshows.*
import tech.medina.tvshows.domain.model.Cast
import tech.medina.tvshows.domain.model.Episode
import tech.medina.tvshows.domain.model.Person
import tech.medina.tvshows.domain.model.Show
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModulesProvider {

    @Provides
    fun providesRetrofitConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideTvMazeService(
        converter: Converter.Factory
    ): TvMazeService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(converter)
            .build()
            .create(TvMazeService::class.java)
    }

}