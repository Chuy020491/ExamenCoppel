package com.example.examencoppel.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoriesModel(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXXModel>,
    val returned: Int
):Parcelable