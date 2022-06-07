package com.poc.di

import android.app.Application
import androidx.room.Room
import com.poc.model.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application) : MovieDatabase =
        Room.databaseBuilder(app, MovieDatabase::class.java, "movie")
            .build()
}