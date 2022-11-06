package com.example.examencoppel.api

import com.example.examencoppel.marvel.model.MarvelModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiClient {
    @GET
    suspend fun getAllSuperHeros(@Url url:String): Response<MarvelModel>
}