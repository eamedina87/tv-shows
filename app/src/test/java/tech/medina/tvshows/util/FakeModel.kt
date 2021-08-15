package tech.medina.tvshows.util

import tech.medina.tvshows.domain.model.Cast
import tech.medina.tvshows.domain.model.Character
import tech.medina.tvshows.domain.model.Person
import tech.medina.tvshows.domain.model.Show

object FakeModel {

    val person = Person(
        id = 157,
        name = "Name LastName"
    )

    val character = Character(
        id = 654,
        name = "Character Name"
    )

    val cast = Cast(
        person = person,
        character = character
    )

    val showInfo = Show(
        id = 123,
        name = "Show Name",
        summary = "This is the show summary",
        imageMedium = "https://static.tvmaze.com/uploads/images/medium_portrait/1/4600.jpg",
        imageOriginal = "https://static.tvmaze.com/uploads/images/original_untouched/1/4600.jpg",,
        episodeList = emptyList(),
        castList = emptyList()
    )

    val showFull = Show(
        id = 123,
        name = "Show Name",
        summary = "This is the show summary",
        imageMedium = "https://static.tvmaze.com/uploads/images/medium_portrait/1/4600.jpg",
        imageOriginal = "https://static.tvmaze.com/uploads/images/original_untouched/1/4600.jpg",,
        episodeList = emptyList(),
        castList = listOf(cast)
    )

}