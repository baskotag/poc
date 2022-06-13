package com.poc.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poc.utility.DBQuery.DELETE_ALL_MOVIES
import com.poc.utility.DBQuery.SELECT_ALL_MOVIES
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query(SELECT_ALL_MOVIES)
    fun getAllMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movie: List<Movie>)

    @Query(DELETE_ALL_MOVIES)
    suspend fun deleteAllMovies()
}