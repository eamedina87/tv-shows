package tech.medina.tvshows.data.tvshows

import androidx.paging.PagingSource
import androidx.paging.PagingState
import tech.medina.tvshows.data.TvMazeService
import javax.inject.Inject

class TvShowsDataSource @Inject constructor(
    private val tvMazeService: TvMazeService
): PagingSource<Int, ShowDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShowDTO> =
        try {
            val currentPage = params.key ?: TvShowsRepository.TV_MAZE_INITIAL_KEY
            val result = tvMazeService.getShows(currentPage)
            LoadResult.Page(
                data = result,
                prevKey = if (currentPage == TvShowsRepository.TV_MAZE_INITIAL_KEY) null else currentPage.minus(1),
                nextKey = currentPage.plus(1)
            )
        } catch (t: Throwable) {
            LoadResult.Error(throwable = t)
        }

    override fun getRefreshKey(state: PagingState<Int, ShowDTO>): Int? =
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

}