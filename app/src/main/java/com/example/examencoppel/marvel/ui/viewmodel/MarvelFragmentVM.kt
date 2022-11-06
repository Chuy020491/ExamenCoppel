package com.example.examencoppel.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examencoppel.marvel.model.SuperHeroModel
import com.example.examencoppel.marvel.usecases.DeleteUserDBUseCase
import com.example.examencoppel.marvel.usecases.GetAllSuperHerosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelFragmentVM @Inject constructor(
    private val getAllSuperHerosUseCase: GetAllSuperHerosUseCase,
    private val deleteUserDBUseCase: DeleteUserDBUseCase
): ViewModel(){
    val marvelModel = MutableLiveData<List<SuperHeroModel>>()
    val searchmarvelModel = MutableLiveData<List<SuperHeroModel>>()
    val isLoading = MutableLiveData<Boolean>()
    val deleteUser = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllSuperHerosUseCase()
            if(!result?.dataModel?.superHeroModels.isNullOrEmpty()){
                marvelModel.postValue(result?.dataModel?.superHeroModels)
                isLoading.postValue(false)
            }

        }
    }

    fun search(filterSuperHero:List<SuperHeroModel>,newText: String){
        var datos = filterSuperHero.filter { x-> x.name.lowercase().contains(newText) }
        searchmarvelModel.postValue(datos)

    }

    fun deleteUserDB(){
        viewModelScope.launch {
            deleteUserDBUseCase.invoke()

        }
    }
}