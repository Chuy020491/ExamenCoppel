package com.example.examencoppel.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemXXXModel(
    val name: String,
    val resourceURI: String,
    val type: String
):Parcelable