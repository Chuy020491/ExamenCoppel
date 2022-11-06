package com.example.examencoppel.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examencoppel.database.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAllUser(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM user")
    suspend fun deleteUser()

}