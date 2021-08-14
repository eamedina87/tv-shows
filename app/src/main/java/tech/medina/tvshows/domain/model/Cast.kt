package tech.medina.tvshows.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface ICast {
    val id: Long
    val name: String
}

@Parcelize
data class Person(
    override val id: Long,
    override val name: String
) : ICast, Parcelable

@Parcelize
data class Character(
    override val id: Long,
    override val name: String
) : ICast, Parcelable

@Parcelize
data class Cast(
    val person: Person?,
    val character: Character?
) : Parcelable