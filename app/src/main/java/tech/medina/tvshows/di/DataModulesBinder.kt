package tech.medina.tvshows.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.medina.tvshows.data.mapper.*
import tech.medina.tvshows.data.tvshows.*
import tech.medina.tvshows.domain.model.Cast
import tech.medina.tvshows.domain.model.Character
import tech.medina.tvshows.domain.model.Episode
import tech.medina.tvshows.domain.model.Person
import tech.medina.tvshows.domain.model.Show

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModulesBinder {

    @Binds
    abstract fun bindShowRepository(
        repository: TvShowsRepository
    ): ITvShowsRepository

    @Binds
    abstract fun bindShowMapper(
        mapper: ShowMapper
    ): IMapper<ShowDTO, Show>

    @Binds
    abstract fun bindEpisodeMapper(
        mapper: EpisodeMapper
    ): IMapper<EpisodeDTO, Episode>

    @Binds
    abstract fun bindCastMapper(
        mapper: CastMapper
    ): IMapper<CastDTO, Cast>

    @Binds
    abstract fun bindPersonMapper(
        mapper: PersonMapper
    ): IMapper<PersonDTO, Person>

    @Binds
    abstract fun bindCharacterMapper(
        mapper: CharacterMapper
    ): IMapper<CharacterDTO, Character>

}