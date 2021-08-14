package tech.medina.tvshows.data.tvshows

import com.google.gson.annotations.SerializedName

data class CastDTO(
    @SerializedName("person") val person: PersonDTO?,
    @SerializedName("character") val character: CharacterDTO?,
)

data class PersonDTO(
    @SerializedName("country")
    val country: String?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("deathday")
    val deathday: String?,
    @SerializedName("gender")
    val gender: String?
): Cast()

class CharacterDTO: Cast()

open class Cast {
    @SerializedName("id")
    val id: Long? = null
    @SerializedName("name")
    val name: String? = null
    @SerializedName("image")
    val image: ImageDTO? = null

    override fun toString(): String {
        return "id:${id} name:${name}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cast

        if (id != other.id) return false
        if (name != other.name) return false
        if (image != other.image) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (image?.hashCode() ?: 0)
        return result
    }

}