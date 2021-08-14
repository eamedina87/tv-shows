package tech.medina.tvshows.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.medina.tvshows.data.tvshows.ShowDTO

interface TvMazeService {

    @GET("shows")
    suspend fun getShows(@Query("page") index: Int): List<ShowDTO>

    @GET("shows/{showId}?embed[]=cast&embed[]=episodes")
    suspend fun getShowDetail(@Path("showId") showId: Long): ShowDTO

}