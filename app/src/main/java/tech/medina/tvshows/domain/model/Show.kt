package tech.medina.tvshows.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface IData {
    val id: Long
    val name: String
    val summary: String
    val imageMedium: String
    val imageOriginal: String
}

@Parcelize
data class Show(
    override val id: Long,
    override val name: String,
    override val summary: String,
    override val imageMedium: String,
    override val imageOriginal: String,
    val episodeList: List<Episode>,
    val castList: List<Cast>
) : IData, Parcelable

@Parcelize
data class Episode(
    override val id: Long,
    override val name: String,
    override val summary: String,
    val seasonNumber: Int,
    val episodeNumber: Int,
    override val imageMedium: String,
    override val imageOriginal: String
) : IData, Parcelable