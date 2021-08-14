package tech.medina.tvshows.domain.usecase

import tech.medina.tvshows.data.tvshows.ITvShowsRepository
import tech.medina.tvshows.domain.model.DataState
import tech.medina.tvshows.domain.model.Show
import java.lang.Exception
import javax.inject.Inject

interface IGetShowDetailUseCase {
    suspend operator fun invoke(showId: Long): DataState<Show>
}

class GetShowDetailUseCase @Inject constructor(
    private val repository: ITvShowsRepository
) : IGetShowDetailUseCase {

    override suspend fun invoke(showId: Long): DataState<Show> =
        try {
            DataState.Success(repository.getTvShowDetail(showId))
        } catch (e: Exception) {
            DataState.Error(e.message)
        }

}