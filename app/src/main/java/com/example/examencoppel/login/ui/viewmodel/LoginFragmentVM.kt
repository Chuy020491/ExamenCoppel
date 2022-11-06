package com.example.examencoppel.login.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examencoppel.login.model.UserModel
import com.example.examencoppel.login.usecases.CreateUserFirebaseUseCase
import com.example.examencoppel.login.usecases.InsertUserDBUseCase
import com.example.examencoppel.login.usecases.SignInUseCase
import com.example.examencoppel.login.usecases.ValidateExistingUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginFragmentVM @Inject constructor(

    private val validateExistingUserUseCase: ValidateExistingUserUseCase,
    private val createUserFirebaseUseCase: CreateUserFirebaseUseCase,
    private val signInUseCase: SignInUseCase,
    private val insertUserDBUseCase: InsertUserDBUseCase
): ViewModel() {
    val userExisting = MutableLiveData<UserModel?>()
    val insertUser = MutableLiveData<String>()
    val correctSignIn = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            val result = validateExistingUserUseCase()
            userExisting.postValue(result)
        }
    }

    fun insertUserFirebase(email:String,password:String){
        viewModelScope.launch {
            val result = createUserFirebaseUseCase.invoke(email,password)
            result.addOnCompleteListener {
                if(it.isSuccessful){
                    insertUser.postValue("Usuario registerado correctamen")
                }else{
                    insertUser.postValue("Error al tratar de registrar un usuario")
                }
            }

        }
    }

    fun signIn(email:String,password:String){
        viewModelScope.launch {
            val result = signInUseCase.invoke(email,password)
            result.addOnCompleteListener {
                if(it.isSuccessful){
                    correctSignIn.postValue(true)
                }else{
                    correctSignIn.postValue(false)
                }
            }

        }
    }

    fun insertUserDB(user: UserModel){
        viewModelScope.launch {
            insertUserDBUseCase.invoke(user)
        }

    }

}