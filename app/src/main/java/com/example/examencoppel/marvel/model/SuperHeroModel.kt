package com.example.examencoppel.marvel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHeroModel(
    @SerializedName("comics") val comicsModel: ComicsModel,
    val description: String,
    @SerializedName("events")val eventsModel: EventsModel,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    @SerializedName("series") val seriesModel: SeriesModel,
    @SerializedName("stories")val storiesModel: StoriesModel,
    @SerializedName("thumbnail")val thumbnailModel: ThumbnailModel,
    @SerializedName("urls")val urlModels: List<UrlModel>
):Parcelable