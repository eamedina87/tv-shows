package tech.medina.tvshows.domain.usecase

import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import tech.medina.tvshows.base.BaseTest
import tech.medina.tvshows.data.tvshows.ITvShowsRepository
import tech.medina.tvshows.domain.model.DataState
import tech.medina.tvshows.util.FakeModel

@ExperimentalCoroutinesApi
class GetShowDetailUseCaseTest : BaseTest() {

    private val repository = mockk<ITvShowsRepository> {
        coEvery { getTvShowDetail(any()) } returns FakeModel.showFull
    }

    @Test
    fun `get show detail successfully`() = dispatcher.runBlockingTest {
        val useCase = GetShowDetailUseCase(repository)
        val detailState = useCase(123)
        coVerifySequence {
            repository.getTvShowDetail(any())
        }
        with(detailState) {
            Truth.assertThat(this).isNotNull()
            this as DataState.Success
            Truth.assertThat(this.result).isEqualTo(FakeModel.showFull)
        }
    }

    @Test
    fun `get show detail with error`() = dispatcher.runBlockingTest {
        val useCase = GetShowDetailUseCase(repository)
        coEvery { repository.getTvShowDetail(any()) } throws Exception("error")
        val detailState = useCase(123)
        coVerifySequence {
            repository.getTvShowDetail(any())
        }
        with(detailState) {
            Truth.assertThat(this).isNotNull()
            this as DataState.Error
            Truth.assertThat(this.error).isEqualTo("error")
        }
    }

}