package com.example.examencoppel.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel(
    val name: String,
    val resourceURI: String
):Parcelable