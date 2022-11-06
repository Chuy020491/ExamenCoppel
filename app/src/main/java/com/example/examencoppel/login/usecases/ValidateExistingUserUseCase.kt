package com.example.examencoppel.login.usecases

import com.example.examencoppel.login.model.UserModel
import com.example.examencoppel.login.repository.LoginFragmentRepository
import javax.inject.Inject

class ValidateExistingUserUseCase @Inject constructor(
    private val repository: LoginFragmentRepository
) {
    suspend operator fun invoke():UserModel?{
        val user = repository.existingUserDB()
        return user
    }
}