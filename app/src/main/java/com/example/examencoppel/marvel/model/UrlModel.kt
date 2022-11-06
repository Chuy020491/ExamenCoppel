package com.example.examencoppel.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UrlModel(
    val type: String,
    val url: String
):Parcelable