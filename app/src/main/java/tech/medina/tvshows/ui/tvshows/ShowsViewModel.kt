package tech.medina.tvshows.ui.tvshows

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tech.medina.tvshows.domain.model.DataState
import tech.medina.tvshows.domain.model.Show
import tech.medina.tvshows.domain.usecase.IGetShowDetailUseCase
import tech.medina.tvshows.domain.usecase.IGetShowListUseCase
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val savedState: SavedStateHandle,
    private val dispatcher: CoroutineDispatcher,
    private val showListUseCase: IGetShowListUseCase,
    private val showDetailUseCase: IGetShowDetailUseCase,
): ViewModel() {

    private val KEY_SHOW_DETAIL = "show.detail"
    private val KEY_SHOW_DETAIL_ERROR = "show.detail.error"
    private val KEY_SHOW_DETAIL_LOADER = "show.detail.loader"

    val detail = savedState.getLiveData<Show>(KEY_SHOW_DETAIL).asFlow()
    val error = savedState.getLiveData<String>(KEY_SHOW_DETAIL_ERROR).asFlow()
    val showLoader = savedState.getLiveData<Boolean>(KEY_SHOW_DETAIL_LOADER).asFlow()

    suspend fun getShowsList() = showListUseCase()

    fun getShowDetail(showId: Long) {
        viewModelScope.launch {
            setShowLoader(true)
            val showDetailState = withContext(dispatcher) {
                showDetailUseCase(showId)
            }
            when (showDetailState) {
                is DataState.Success -> setTvShowDetail(showDetailState.result)
                is DataState.Error -> setError(showDetailState.error.toString())
            }
            setShowLoader(false)
        }
    }

    private fun setTvShowDetail(value: Show) {
        savedState.set(KEY_SHOW_DETAIL, value)
    }

    private fun setError(value: String) {
        savedState.set(KEY_SHOW_DETAIL_ERROR, value)
    }

    private fun setShowLoader(value: Boolean) {
        savedState.set(KEY_SHOW_DETAIL_LOADER, value)
    }

}