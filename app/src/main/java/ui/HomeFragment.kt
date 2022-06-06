package ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.poc.R
import factory.MovieFactory
import network.RetrofitService
import repository.MovieRepository
import viewModel.MovieViewModel
class HomeFragment : Fragment() {
    lateinit var viewModel: MovieViewModel
    private val retrofitService = RetrofitService.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, MovieFactory(MovieRepository(retrofitService))).get(
            MovieViewModel::class.java
        )
        viewModel.movieList.observe(viewLifecycleOwner) {
            Log.d(TAG, "On success$it")
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Log.d(TAG, "On Fail $it")
        }
        viewModel.getAllMovies()
    }
}