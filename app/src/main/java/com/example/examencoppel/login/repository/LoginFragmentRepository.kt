package com.example.examencoppel.login.repository

import com.example.examencoppel.database.dao.UserDao
import com.example.examencoppel.database.entities.UserEntity
import com.example.examencoppel.login.model.UserModel
import com.example.examencoppel.login.model.toDomain
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginFragmentRepository @Inject constructor(
    private val userDao: UserDao
){
    fun insertUserFirebase(email: String, password: String): Task<AuthResult> {
        return FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
    }

    fun signInFirebase(email: String, password: String): Task<AuthResult> {
        return FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    }

    suspend fun existingUserDB(): UserModel? {
        val response: UserEntity? = userDao.getAllUser()
        return response?.toDomain()
    }

    suspend fun insertUserDB(user: UserEntity) {
        userDao.insertUser(user)
    }
}