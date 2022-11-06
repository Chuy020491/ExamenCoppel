package com.example.examencoppel.login.usecases

import com.example.examencoppel.login.repository.LoginFragmentRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val loginFragmentRepository: LoginFragmentRepository
) {
    operator fun invoke(email: String, password: String): Task<AuthResult> {
        return loginFragmentRepository.signInFirebase(email, password)
    }
}