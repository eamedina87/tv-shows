package tech.medina.tvshows.data.tvshows

import com.google.gson.annotations.SerializedName

data class ShowDTO(
    @SerializedName("genres") val genres: List<String?>?,
    @SerializedName("language") val language: String?,
    @SerializedName("premiered") val premiered: String?,
    @SerializedName("_embedded") val embedded: EmbeddedDTO?
): Info()

data class EpisodeDTO(
    @SerializedName("season") val season: Int?,
    @SerializedName("number") val number: Int?,
    @SerializedName("airdate") val airDate: String?,
): Info()

data class ImageDTO(
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
)

data class EmbeddedDTO(
    @SerializedName("cast") val cast: List<CastDTO?>?,
    @SerializedName("episodes") val episodes: List<EpisodeDTO?>?
)

open class Info {
    @SerializedName("id")
    val id: Long? = null
    @SerializedName("name")
    val name: String? = null
    @SerializedName("image")
    val image: ImageDTO? = null
    @SerializedName("runtime")
    val runtimeInMinutes: Int? = null
    @SerializedName("summary")
    val summary: String? = null
}