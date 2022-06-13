package com.poc.utility

import retrofit2.http.DELETE

object DBQuery {
    const val DATA_BASE_VERSION: Int = 1
    const val DATA_BASE_NAME: String = "movie"
    const val SELECT_ALL_MOVIES: String = "SELECT * FROM movie"
    const val DELETE_ALL_MOVIES: String = "DELETE FROM movie"

}