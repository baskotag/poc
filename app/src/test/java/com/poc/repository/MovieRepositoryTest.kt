package com.poc.repository

import com.poc.model.Movie
import com.poc.model.MovieDao
import com.poc.network.RetrofitService
import com.poc.utils.BaseUnitTest
import kotlinx.coroutines.flow.*

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlinx.coroutines.flow.Flow


@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest : BaseUnitTest() {
    private val api: RetrofitService = mock()
    private val movieList = mock<List<Movie>>()
    private val movieList1 = mock<Flow<List<Movie>>>()
    private val movieDao: MovieDao = mock()
    private val exception = emptyList<Movie>()


    @Test
    fun fetchMovieListFromAPISuccess() = runBlockingTest {
        mockSuccessfulCaseAPI()
        assertEquals(movieList, api.getAllMovies())
    }

    @Test
    fun fetchMovieListFromAPIError() = runBlockingTest {
        mockErrorCaseAPI()
        assertEquals(exception, api.getAllMovies())
    }

    @Test
    fun fetchMovieListFromDatabaseSuccess() = runBlockingTest {
        mockSuccessfulCaseDB()
        assertEquals(movieList1, movieDao.getAllMovies())
    }

    @Test
    fun fetchMovieListFromDatabaseError() = runBlockingTest {
        mockErrorCaseDB()
        movieDao.getAllMovies().collect {
            assertEquals(exception, it)
        }
    }

    private fun mockSuccessfulCaseDB() {
        whenever(movieDao.getAllMovies()).thenReturn(movieList1)
    }

    private fun mockErrorCaseDB() {
        whenever(movieDao.getAllMovies()).thenReturn(
            flow {
                exception
            }
        )
    }

    private suspend fun mockSuccessfulCaseAPI() {
        whenever(api.getAllMovies()).thenReturn(
            movieList
        )
    }

    private suspend fun mockErrorCaseAPI() {
        whenever(api.getAllMovies()).thenReturn(emptyList())
    }
}

