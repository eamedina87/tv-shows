package tech.medina.tvshows.domain.model

sealed class DataState<out T> {
    class Success<out T>(val result: T): DataState<T>()
    class Error(val error: Any?): DataState<Nothing>()
}