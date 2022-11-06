package com.example.examencoppel.marvel.usecases

import com.example.examencoppel.marvel.repository.MarvelFragmentRepository
import javax.inject.Inject

class DeleteUserDBUseCase @Inject constructor(
    private val repository: MarvelFragmentRepository
) {
    suspend operator fun invoke(){
        repository.deleteUserDB()
    }
}