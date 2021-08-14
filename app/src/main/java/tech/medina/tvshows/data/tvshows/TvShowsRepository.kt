package tech.medina.tvshows.data.tvshows

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.medina.tvshows.data.TvMazeService
import tech.medina.tvshows.data.mapper.IMapper
import tech.medina.tvshows.domain.model.Show
import javax.inject.Inject

interface ITvShowsRepository {
    suspend fun getTvShows(): Flow<PagingData<Show>>
    suspend fun getTvShowDetail(id: Long): Show
}

class TvShowsRepository @Inject constructor(
    private val tvShowsDataSource: TvShowsDataSource,
    private val tvMazeService: TvMazeService,
    private val showMapper: IMapper<ShowDTO, Show>
): ITvShowsRepository {

    companion object {
        const val TV_MAZE_SHOWS_PER_PAGE = 250
        const val TV_MAZE_INITIAL_KEY = 0
    }

    override suspend fun getTvShows(): Flow<PagingData<Show>> =
        Pager(
            PagingConfig(pageSize = TV_MAZE_SHOWS_PER_PAGE)
        ) {
            tvShowsDataSource
        }.flow.map { pagingData ->
            pagingData.map {
                showMapper.map(it)
            }
        }

    override suspend fun getTvShowDetail(id: Long): Show =
        showMapper.map(tvMazeService.getShowDetail(id))

}