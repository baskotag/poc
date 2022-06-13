package com.poc.repository
import androidx.room.withTransaction
import com.poc.model.MovieDatabase
import com.poc.network.RetrofitService
import com.poc.utility.taskOperator
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val db: MovieDatabase
) {
    private val movieDao = db.movieDao()

    fun getAllMovies() =
        taskOperator(
            query = {
                movieDao.getAllMovies()
            },
            fetch = {
                retrofitService.getAllMovies()
            },
            saveFetchResult = {
                db.withTransaction {
                    movieDao.deleteAllMovies()
                    movieDao.insertMovies(it)
                }
            }
        )
}