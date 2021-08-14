package tech.medina.tvshows.domain.model

interface IData {
    val id: Long
    val name: String
    val summary: String
    val imageMedium: String
    val imageOriginal: String
}

data class Show(
    override val id: Long,
    override val name: String,
    override val summary: String,
    override val imageMedium: String,
    override val imageOriginal: String,
    val episodeList: List<Episode>,
    val castList: List<Cast>
) : IData

data class Episode(
    override val id: Long,
    override val name: String,
    override val summary: String,
    val seasonNumber: Int,
    val episodeNumber: Int,
    override val imageMedium: String,
    override val imageOriginal: String
) : IData