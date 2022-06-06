package com.poc.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poc.R
import com.poc.action.OnClickListener
import com.poc.databinding.FragmentHomeBinding
import com.poc.factory.MovieFactory
import com.poc.model.Movie
import com.poc.network.RetrofitService
import com.poc.repository.MovieRepository
import com.poc.utility.AppConstant
import com.poc.viewModel.MovieViewModel

class HomeFragment : Fragment(), OnClickListener {
    lateinit var viewModel: MovieViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, MovieFactory(MovieRepository(retrofitService))).get(
            MovieViewModel::class.java
        )
        viewModel.movieList.observe(viewLifecycleOwner) {
            binding.progressbar.visibility = GONE
            viewModel.setAdapterData(it as ArrayList<Movie>, binding.recyclerView, this)
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) {
        }
        viewModel.getAllMovies()
    }

    override fun onclick(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstant.dataPassingKey, movie)
        findNavController().graph.setStartDestination(R.id.detailsFragment)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }
}