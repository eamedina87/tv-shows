package tech.medina.tvshows.data.mapper

import tech.medina.tvshows.data.tvshows.CastDTO
import tech.medina.tvshows.data.tvshows.CharacterDTO
import tech.medina.tvshows.data.tvshows.PersonDTO
import tech.medina.tvshows.domain.model.Cast
import tech.medina.tvshows.domain.model.Person
import tech.medina.tvshows.domain.model.Character
import javax.inject.Inject

class CastMapper @Inject constructor(
    private val personMapper: IMapper<PersonDTO, Person>,
    private val characterMapper: IMapper<CharacterDTO, Character>
) : IMapper<CastDTO, Cast> {

    override fun map(input: CastDTO): Cast =
        Cast(
            person = if (input.person == null) null else personMapper.map(input.person),
            character = if (input.character == null) null else characterMapper.map(input.character)
        )

}

class PersonMapper @Inject constructor() : IMapper<PersonDTO, Person> {

    override fun map(input: PersonDTO): Person =
        Person(
            id = input.id ?: -1,
            name = input.name ?: ""
        )

}

class CharacterMapper @Inject constructor() : IMapper<CharacterDTO, Character> {

    override fun map(input: CharacterDTO) : Character =
        Character(
            id = input.id ?: -1,
            name = input.name ?: ""
        )

}

