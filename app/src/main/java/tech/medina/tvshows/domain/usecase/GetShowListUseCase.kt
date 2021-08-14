package tech.medina.tvshows.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import tech.medina.tvshows.data.tvshows.ITvShowsRepository
import tech.medina.tvshows.domain.model.Show
import javax.inject.Inject

interface IGetShowListUseCase {
    suspend operator fun invoke(): Flow<PagingData<Show>>
}

class GetShowListUseCase @Inject constructor(
    private val repository: ITvShowsRepository
) : IGetShowListUseCase {

    override suspend fun invoke(): Flow<PagingData<Show>> =
        repository.getTvShows()

}