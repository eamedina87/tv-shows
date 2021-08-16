package tech.medina.tvshows.ui.tvshows

import androidx.lifecycle.SavedStateHandle
import androidx.paging.PagingData
import app.cash.turbine.test
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import tech.medina.tvshows.base.BaseTest
import tech.medina.tvshows.domain.model.DataState
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.domain.usecase.IGetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.IGetShowListUseCase
import tech.medina.tvshows.util.FakeModel
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
class ShowsViewModelTest : BaseTest() {

    private val showsListUseCase = mockk<IGetShowListUseCase> {
        coEvery { this@mockk.invoke() } returns flow<PagingData<Show>> { }
    }

    private val showDetailUseCase = mockk<IGetShowDetailUseCase> {
        coEvery { this@mockk.invoke(any()) } returns DataState.Success(FakeModel.showFull)
    }

    private val savedStateHandle = mockk<SavedStateHandle>(relaxed = true)

    @Test
    fun `get show list successfully`() = dispatcher.runBlockingTest {
        val viewModel = ShowsViewModel(savedStateHandle, dispatcher, showsListUseCase, showDetailUseCase)
        viewModel.getShowsList().toList()
        coVerify {
            showsListUseCase()
        }
        coVerify(exactly = 0) {
            showDetailUseCase(any())
        }
    }

    @Test
    fun `get show detail successfully`() = dispatcher.runBlockingTest {
        val viewModel = ShowsViewModel(savedStateHandle, dispatcher, showsListUseCase, showDetailUseCase)
        viewModel.getShowDetail(123)
        coVerify {
            showDetailUseCase(123)
        }
    }

}