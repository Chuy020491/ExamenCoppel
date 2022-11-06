package com.example.examencoppel.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.examencoppel.login.model.UserModel

@Entity(tableName = "User")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val email:String,
    val password:String
)

fun UserModel.toDataBase() = UserEntity(
    id = idUser,
    email = email,
    password = password
)
