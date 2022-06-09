package com.poc.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.test.core.app.ApplicationProvider
import com.poc.di.AppModule
import com.poc.model.Movie
import com.poc.network.RetrofitService
import com.poc.repository.MovieRepository
import junit.framework.TestCase
import org.junit.Test

class MovieViewModelTest : TestCase() {

    @Test
    fun testGetResponse() {
        val appModule = AppModule
        val retrofitService = RetrofitService.getInstance()
        var movieRepository = MovieRepository(
            retrofitService,
            appModule.provideDatabase(ApplicationProvider.getApplicationContext())
        )
        movieRepository.getAllMovies()
        var movieViewModel = MovieViewModel(movieRepository);

    }
}

