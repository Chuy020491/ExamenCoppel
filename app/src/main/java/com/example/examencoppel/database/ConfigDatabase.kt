package com.example.examencoppel.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examencoppel.database.dao.UserDao
import com.example.examencoppel.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class ConfigDatabase:RoomDatabase() {
    abstract fun getUser(): UserDao
}