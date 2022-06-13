package com.poc.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.poc.action.OnClickListener
import com.poc.model.Movie
import com.poc.repository.MovieRepository
import com.poc.ui.MovieAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(repository: MovieRepository) : ViewModel() {

    fun setAdapterData(data: ArrayList<Movie>, adapter: RecyclerView, action: OnClickListener) {
        adapter.adapter = MovieAdapter(data, action)
    }

    val response = repository.getAllMovies().asLiveData()
}