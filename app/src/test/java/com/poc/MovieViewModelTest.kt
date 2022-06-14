package com.poc

import com.poc.model.Movie
import com.poc.repository.MovieRepository
import com.poc.utility.ServiceStates
import com.poc.utils.BaseUnitTest
import com.poc.utils.getValueForTest
import com.poc.viewModel.MovieViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.lang.RuntimeException

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest : BaseUnitTest() {
    private val repository: MovieRepository = mock()
    private val movieList = mock<ServiceStates<List<Movie>>>()
    private val expected = movieList
    private val exception = movieList

    @Test
    fun emitMovieListFromRepository() {
        val viewModel = successCase()
        Assert.assertEquals(expected, viewModel.response.getValueForTest())
    }

    @Test
    fun getMovieListFromRepository(): Unit = runBlocking {
        val viewModel = successCase()
        viewModel.response.getValueForTest()
        verify(repository, times(1)).getAllMovies()
    }

    @Test
    fun errorCase() {
        val viewModel = mockErrorCase()
        Assert.assertEquals(exception, viewModel.response.getValueForTest())
    }

    private fun successCase(): MovieViewModel {
        runBlocking {
            whenever(repository.getAllMovies()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }
        return MovieViewModel(repository)
    }

    private fun mockErrorCase(): MovieViewModel {
        runBlocking {
            whenever(repository.getAllMovies()).thenReturn(
                flow {
                    expected.error = RuntimeException("Something went wrong")
                    emit(expected)
                }
            )
        }
        return MovieViewModel(repository)
    }

}


