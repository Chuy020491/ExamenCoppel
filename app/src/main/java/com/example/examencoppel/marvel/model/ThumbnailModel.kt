package com.example.examencoppel.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThumbnailModel(
    val extension: String,
    val path: String
):Parcelable