package com.poc.network

import com.poc.model.Movie
import com.poc.network.APIConstant.BASE_URL
import com.poc.network.APIConstant.MethodNames.movieList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET(movieList)
    fun getAllMovies(): Call<List<Movie>>
    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}