package tech.medina.tvshows.domain.usecase

import androidx.paging.PagingData
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import tech.medina.tvshows.base.BaseTest
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.util.FakeRepo

@ExperimentalCoroutinesApi
class GetShowListUseCaseTest : BaseTest() {

    @Test
    fun `get show list successfully`() = dispatcher.runBlockingTest {
        val repository = FakeRepo.repository
        val useCase = GetShowListUseCase(repository)
        val shows = useCase()
        with(shows) {
            Truth.assertThat(this).isNotNull()
            Truth.assertThat(this is Flow<PagingData<Show>>)
        }
    }

}