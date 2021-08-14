package tech.medina.tvshows.data.mapper

interface IMapper<T, R> {
    fun map(input: T): R
}