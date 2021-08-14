package tech.medina.tvshows.data.tvshows

import androidx.paging.PagingSource
import com.google.common.truth.Truth
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import tech.medina.tvshows.base.BaseTest
import tech.medina.tvshows.data.TvMazeService
import tech.medina.tvshows.data.mapper.IMapper
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.util.FakeDTO
import tech.medina.tvshows.util.FakeModel

@ExperimentalCoroutinesApi
class TvShowsRepositoryTest: BaseTest() {

    private val tvMazeService = mockk<TvMazeService> {
        coEvery { getShows(any()) } returns listOf(FakeDTO.showInfo, FakeDTO.showFull)
        coEvery { getShowDetail(any()) } returns FakeDTO.showFull
    }

    private val showMapper = mockk<IMapper<ShowDTO, Show>> {
        every { map(any()) } returns FakeModel.showFull
    }

    private val tvShowsDataSource = mockk<TvShowsDataSource> {
        coEvery { load(any()) } returns PagingSource.LoadResult.Page(FakeDTO.showList, null, 1)
    }

    @Test
    fun `get show detail successfully`() = dispatcher.runBlockingTest {
        val repository = TvShowsRepository(tvShowsDataSource, tvMazeService, showMapper)
        val showDetail = repository.getTvShowDetail(123)
        coVerifySequence {
            tvMazeService.getShowDetail(any())
            showMapper.map(any())
        }
        with(showDetail) {
            Truth.assertThat(this).isNotNull()
            Truth.assertThat(this).isEqualTo(FakeModel.showFull)
        }
    }

    @Test
    fun `get show detail with exception`() = dispatcher.runBlockingTest {
        val repository = TvShowsRepository(tvShowsDataSource, tvMazeService, showMapper)
        coEvery { repository.getTvShowDetail(any()) } throws Exception()
        val showDetail = try {
             repository.getTvShowDetail(123)
        } catch (e: Exception) {
            e
        }
        coVerifySequence {
            tvMazeService.getShowDetail(any())
        }
        coVerify (exactly = 0) {
            showMapper.map(any())
        }
        with(showDetail){
            Truth.assertThat(this).isNotNull()
            Truth.assertThat(this is Exception)
        }
    }

}