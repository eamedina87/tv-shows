package tech.medina.tvshows.data.tvshows

import com.google.gson.annotations.SerializedName

interface ICastDTO {
    val id: Long?
    val name: String?
    val image: ImageDTO?
}

data class CastDTO(
    @SerializedName("person") val person: PersonDTO?,
    @SerializedName("character") val character: CharacterDTO?,
)

data class PersonDTO(
    @SerializedName("id")
    override val id: Long?,
    @SerializedName("name")
    override val name: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("deathday")
    val deathday: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("image")
    override val image: ImageDTO?
): ICastDTO

class CharacterDTO(
    @SerializedName("id")
    override val id: Long,
    @SerializedName("name")
    override val name: String?,
    @SerializedName("image")
    override val image: ImageDTO?
): ICastDTO