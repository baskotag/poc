package com.poc.network

import com.poc.model.Movie
import com.poc.network.APIConstant.MethodNames.movieList
import retrofit2.http.GET

interface RetrofitService {
    @GET(movieList)
    suspend fun getAllMovies(): List<Movie>
}