package tech.medina.tvshows.data.tvshows

import com.google.gson.annotations.SerializedName

interface IDataDTO {
    val id: Long?
    val name: String?
    val image: ImageDTO?
    val summary: String?
    val runtimeInMinutes: Int?
}

data class ShowDTO(
    @SerializedName("id")
    override val id: Long?,
    @SerializedName("name")
    override val name: String?,
    @SerializedName("summary")
    override val summary: String?,
    @SerializedName("image")
    override val image: ImageDTO?,
    @SerializedName("runtime")
    override val runtimeInMinutes: Int?,
    @SerializedName("rating")
    val rating: RatingDTO?,
    @SerializedName("genres")
    val genres: List<String?>?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("premiered")
    val premiered: String?,
    @SerializedName("_embedded")
    val embedded: EmbeddedDTO?,
) : IDataDTO

data class EpisodeDTO(
    @SerializedName("id")
    override val id: Long?,
    @SerializedName("name")
    override val name: String?,
    @SerializedName("image")
    override val image: ImageDTO?,
    @SerializedName("runtime")
    override val runtimeInMinutes: Int?,
    @SerializedName("summary")
    override val summary: String?,
    @SerializedName("season")
    val season: Int?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("airdate")
    val airDate: String?,
) : IDataDTO

data class ImageDTO(
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
)

data class RatingDTO(
    @SerializedName("average") val average: Double?,
)

data class EmbeddedDTO(
    @SerializedName("cast") val cast: List<CastDTO?>?,
    @SerializedName("episodes") val episodes: List<EpisodeDTO?>?
)