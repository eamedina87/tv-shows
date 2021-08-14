package tech.medina.tvshows.util

import androidx.paging.PagingSource
import io.mockk.*
import kotlinx.coroutines.flow.flow
import tech.medina.tvshows.data.TvMazeService
import tech.medina.tvshows.data.mapper.IMapper
import tech.medina.tvshows.data.tvshows.ITvShowsRepository
import tech.medina.tvshows.data.tvshows.ShowDTO
import tech.medina.tvshows.data.tvshows.TvShowsDataSource
import tech.medina.tvshows.data.tvshows.TvShowsRepository
import tech.medina.tvshows.domain.model.Show

object FakeRepo {

    private val tvShowsDataSource = mockk<TvShowsDataSource> {
        coEvery { load(any()) } returns PagingSource.LoadResult.Page(FakeDTO.showList, null, 1)
        every { registerInvalidatedCallback(any()) } just Runs
        every { invalid } returns false
    }

    private val tvMazeService = mockk<TvMazeService> {
        coEvery { getShows(any()) } returns listOf(FakeDTO.showInfo, FakeDTO.showFull)
        coEvery { getShowDetail(any()) } returns FakeDTO.showFull
    }

    private val showMapper = mockk<IMapper<ShowDTO, Show>> {
        every { map(any()) } returns FakeModel.showFull
    }

    val repository = TvShowsRepository(tvShowsDataSource, tvMazeService, showMapper)

}