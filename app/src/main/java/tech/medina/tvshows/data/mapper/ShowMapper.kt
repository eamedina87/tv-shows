package tech.medina.tvshows.data.mapper

import tech.medina.tvshows.data.tvshows.ShowDTO
import tech.medina.tvshows.domain.model.Show
import javax.inject.Inject

class ShowMapper @Inject constructor(): IMapper<ShowDTO, Show> {

    override fun map(input: ShowDTO): Show =
        Show(
            id = input.id ?: -1,
            name = input.name ?: "",
            summary = input.name ?: ""
        )

}