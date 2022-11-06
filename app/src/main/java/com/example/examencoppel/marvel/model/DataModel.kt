package com.example.examencoppel.marvel.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
  @SerializedName("results")  val superHeroModels: List<SuperHeroModel>,
    val total: Int
)