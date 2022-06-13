package com.poc.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.poc.di.DIMethods
import com.poc.network.RetrofitService
import com.poc.repository.MovieRepository
import com.poc.test.MainCoroutineScopeRule
import com.poc.test.getValueForTest
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelShould {
    @get:Rule
    var coroutineTestRole = MainCoroutineScopeRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    val appModule = DIMethods
    val retrofitService = RetrofitService.getInstance()

    var movieRepository = MovieRepository(
        retrofitService,
        appModule.provideDatabase(ApplicationProvider.getApplicationContext())
    )

    var movieViewModel = MovieViewModel(movieRepository);

    @Test
    fun getMovieListFromRepository() = runBlockingTest {
        movieViewModel.response.getValueForTest()
        verify(movieRepository, times(1)).getAllMovies()
    }
}