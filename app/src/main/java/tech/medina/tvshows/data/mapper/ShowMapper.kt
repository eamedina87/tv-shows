package tech.medina.tvshows.data.mapper

import tech.medina.tvshows.data.tvshows.CastDTO
import tech.medina.tvshows.data.tvshows.EpisodeDTO
import tech.medina.tvshows.data.tvshows.ShowDTO
import tech.medina.tvshows.domain.model.Cast
import tech.medina.tvshows.domain.model.Episode
import tech.medina.tvshows.domain.model.Show
import javax.inject.Inject

class ShowMapper @Inject constructor(
    private val episodeMapper: IMapper<EpisodeDTO, Episode>,
    private val castMapper: IMapper<CastDTO, Cast>,
): IMapper<ShowDTO, Show> {

    override fun map(input: ShowDTO): Show =
        Show(
            id = input.id ?: -1,
            name = input.name ?: "",
            summary = input.name ?: "",
            imageMedium = input.image?.medium ?: "",
            imageOriginal = input.image?.original ?: "",
            episodeList = input.embedded?.episodes?.filterNotNull()?.map { episodeMapper.map(it) } ?: listOf(),
            castList = input.embedded?.cast?.filterNotNull()?.map { castMapper.map(it) } ?: listOf()
        )

}

class EpisodeMapper @Inject constructor(): IMapper<EpisodeDTO, Episode> {

    override fun map(input: EpisodeDTO): Episode =
        Episode(
            id = input.id ?: -1,
            name = input.name ?: "",
            summary = input.summary ?: "",
            seasonNumber = input.season ?: -1,
            episodeNumber = input.number ?: -1,
            imageMedium = input.image?.medium ?: "",
            imageOriginal = input.image?.original ?: ""
        )

}