package com.poc.factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poc.repository.MovieRepository
import com.poc.viewModel.MovieViewModel
import java.lang.IllegalArgumentException

class MovieFactory constructor(private val repository: MovieRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MovieViewModel::class.java))
        {
            MovieViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}