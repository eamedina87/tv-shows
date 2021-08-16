package tech.medina.tvshows.util

import tech.medina.tvshows.data.tvshows.*

object FakeDTO {

    val image = ImageDTO(
        medium = "https://static.tvmaze.com/uploads/images/medium_portrait/1/4600.jpg",
        original = "https://static.tvmaze.com/uploads/images/original_untouched/1/4600.jpg"
    )

    val person = PersonDTO(
        id = 123,
        name = "Name Lastname",
        image = image,
        birthday = "05-09-1965",
        deathday = "27-04-2017",
        gender = "male"
    )

    val character = CharacterDTO(
        id = 567,
        name = "The Character",
        image = image
    )

    val cast = CastDTO(
        person = person,
        character = character
    )

    val episode = EpisodeDTO(
        id = 984,
        name = "Episode Name",
        image = image,
        runtimeInMinutes = 35,
        summary = "This is the episode summary",
        season = 4,
        number = 7,
        airDate = "2017-08-24"
    )

    val embedded = EmbeddedDTO(
        cast = listOf(cast),
        episodes = listOf(episode)
    )

    val rating = RatingDTO(
        average = 10.0
    )

    val showInfo = ShowDTO (
        id = 783,
        name = "Show Name",
        genres = listOf("comedy"),
        language = "english",
        premiered = "15-05-2009",
        image = image,
        runtimeInMinutes = 55,
        embedded = null,
        rating = rating,
        summary = "The summary"
    )

    val showFull = ShowDTO(
        id = 783,
        name = "Show Name",
        genres = listOf("comedy"),
        language = "english",
        premiered = "15-05-2009",
        image = image,
        runtimeInMinutes = 55,
        embedded = embedded,
        summary = "The summary",
        rating = rating
    )

    val showList = listOf(showInfo)

}