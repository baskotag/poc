package com.poc.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.poc.action.OnClickListener
import com.poc.model.Movie
import com.poc.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.poc.ui.MovieAdapter
import retrofit2.awaitResponse
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel()
{

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun setAdapterData(data: ArrayList<Movie>, adapter: RecyclerView,action: OnClickListener) {
        adapter.adapter = MovieAdapter(data,action)
    }
    val response = repository.getAllMovies().asLiveData()

//    fun getAllMovies()
//    {
//        val response1 = repository.getNetworkMovies()
//        Log.d("Tag","On From the re${response1}")
//
//
//        //val response = repository.getNetworkMovies()
//
//
//        response.enqueue(object : Callback<List<Movie>>
//        {
//            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//                movieList.postValue(response.body())
//            }
//            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
//                errorMessage.postValue(t.message)
//            }
//        })
//
//
//    }
}