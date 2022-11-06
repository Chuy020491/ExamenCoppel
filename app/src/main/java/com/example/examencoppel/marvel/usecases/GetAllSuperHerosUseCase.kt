package com.example.examencoppel.marvel.usecases

import com.example.examencoppel.marvel.model.MarvelModel
import com.example.examencoppel.marvel.repository.MarvelFragmentRepository
import javax.inject.Inject

class GetAllSuperHerosUseCase @Inject constructor(
    private val marvelFragmentRepository: MarvelFragmentRepository
){
    suspend operator fun invoke(): MarvelModel?{
        return marvelFragmentRepository.getAllSuperHeros()
    }
}