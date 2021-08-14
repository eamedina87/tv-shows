package tech.medina.tvshows.domain.model

interface ICast {
    val id: Long
    val name: String
}

data class Person(
    override val id: Long,
    override val name: String
) : ICast

data class Character(
    override val id: Long,
    override val name: String
) : ICast

data class Cast(
    val person: Person?,
    val character: Character?
)