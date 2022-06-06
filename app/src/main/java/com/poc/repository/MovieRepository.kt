package com.poc.repository

import com.poc.network.RetrofitService

class MovieRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}