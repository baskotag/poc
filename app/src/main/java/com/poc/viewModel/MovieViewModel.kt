package com.poc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.poc.action.OnClickListener
import com.poc.model.Movie
import com.poc.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.poc.ui.MovieAdapter

class MovieViewModel constructor(private val repository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun setAdapterData(data: ArrayList<Movie>, adapter: RecyclerView,action: OnClickListener) {
        adapter.adapter = MovieAdapter(data,action)
    }

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}