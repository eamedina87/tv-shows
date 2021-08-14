package tech.medina.tvshows.data

import retrofit2.http.GET
import retrofit2.http.Path
import tech.medina.tvshows.data.tvshows.ShowDTO

interface TvMazeService {

    @GET("shows?page={pageIndex}")
    suspend fun getShows(@Path("pageIndex") index: Int): List<ShowDTO>

    @GET("shows/{showId}?embed[]=cast&embed[]=episodes")
    suspend fun getShowDetail(@Path("showId") showId: Long): ShowDTO

}