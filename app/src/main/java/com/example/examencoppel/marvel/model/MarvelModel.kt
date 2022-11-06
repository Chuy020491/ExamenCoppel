package com.example.examencoppel.marvel.model

import com.google.gson.annotations.SerializedName

data class MarvelModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @SerializedName("data") val dataModel: DataModel,
    val etag: String,
    val status: String
)