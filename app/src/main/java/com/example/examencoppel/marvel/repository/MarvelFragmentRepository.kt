package com.example.examencoppel.marvel.repository

import com.example.examencoppel.api.ApiService
import com.example.examencoppel.database.dao.UserDao
import com.example.examencoppel.marvel.model.MarvelModel
import com.example.examencoppel.marvel.model.MarvelProvider
import com.example.examencoppel.utils.Constans
import javax.inject.Inject

class MarvelFragmentRepository @Inject constructor(
    private val api: ApiService,
    private val marvelProvider: MarvelProvider,
    private val userDao: UserDao
){
    suspend fun getAllSuperHeros():MarvelModel{
        val response: MarvelModel = api.getAllSuperHeros("characters?ts=1&apikey=${Constans.PUBLIC_KEY}&hash=${Constans.HASH_MD5}")
        marvelProvider.superHerosMArvel = response
        return response
    }

    suspend fun deleteUserDB() {
        userDao.deleteUser()
    }


}