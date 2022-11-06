package com.example.examencoppel.marvel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventsModel(
    val available: Int,
    val collectionURI: String,
 @SerializedName("items") val itemModels: List<ItemModel>,
    val returned: Int
):Parcelable