package com.example.examencoppel.login.usecases

import com.example.examencoppel.database.entities.toDataBase
import com.example.examencoppel.login.model.UserModel
import com.example.examencoppel.login.repository.LoginFragmentRepository
import javax.inject.Inject

class InsertUserDBUseCase @Inject constructor(
    private val repository: LoginFragmentRepository
){
    suspend operator fun invoke(user:UserModel){
        repository.insertUserDB(user.toDataBase())
    }
}