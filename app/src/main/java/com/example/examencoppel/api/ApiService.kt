package com.example.examencoppel.api

import com.example.examencoppel.marvel.model.MarvelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(
    private val api:ApiClient
) {
    suspend fun getAllSuperHeros(uriApi:String):MarvelModel{
        return  withContext(Dispatchers.IO){
            val response = api.getAllSuperHeros(uriApi)
            response.body()!!
        }
    }
}