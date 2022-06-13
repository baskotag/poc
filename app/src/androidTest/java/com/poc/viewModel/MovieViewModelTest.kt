package com.poc.viewModel

import androidx.test.core.app.ApplicationProvider
import com.poc.di.DIMethods
import com.poc.network.RetrofitService
import com.poc.repository.MovieRepository
import junit.framework.TestCase
import org.junit.Test

class MovieViewModelTest : TestCase() {

    @Test
    fun testGetResponse()
    {
        val appModule = DIMethods
        //val retrofitService = RetrofitService.getInstance()
//        var movieRepository = MovieRepository(
//            retrofitService,
//            appModule.provideDatabase(ApplicationProvider.getApplicationContext())
//        )
//        movieRepository.getAllMovies()
//        var movieViewModel = MovieViewModel(movieRepository);

    }
}

