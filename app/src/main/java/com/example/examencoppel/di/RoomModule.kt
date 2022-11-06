package com.example.examencoppel.di

import android.content.Context
import androidx.room.Room
import com.example.examencoppel.database.ConfigDatabase
import com.example.examencoppel.utils.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ConfigDatabase::class.java, Constans.CONFIG_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db:ConfigDatabase) = db.getUser()
}