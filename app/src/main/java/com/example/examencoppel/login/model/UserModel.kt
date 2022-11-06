package com.example.examencoppel.login.model

import com.example.examencoppel.database.entities.UserEntity

data class UserModel (
    var idUser:Int,
    var email:String,
    var password: String
)

fun UserEntity.toDomain() = UserModel(id,email,password)