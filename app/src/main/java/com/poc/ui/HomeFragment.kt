package com.poc.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poc.MovieApplication
import com.poc.R
import com.poc.action.OnClickListener
import com.poc.databinding.FragmentHomeBinding
import com.poc.di.AppModule
import com.poc.factory.MovieFactory
import com.poc.model.Movie
import com.poc.network.RetrofitService
import com.poc.repository.MovieRepository
import com.poc.utility.AppConstant
import com.poc.viewModel.MovieViewModel

class HomeFragment : Fragment(), OnClickListener {
    lateinit var viewModel: MovieViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val appModule = AppModule
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
        viewModel = ViewModelProvider(
            this,
            MovieFactory(
                MovieRepository(
                    retrofitService,
                    appModule.provideDatabase(activity?.application as Application)
                )
            )
        ).get(
            MovieViewModel::class.java
        )
        viewModel.response.observe(viewLifecycleOwner) {
            binding.progressbar.visibility = GONE
            viewModel.setAdapterData(it.data as ArrayList<Movie>, binding.recyclerView, this)
        }

    }
    override fun onclick(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstant.dataPassingKey, movie)
        findNavController().graph.setStartDestination(R.id.detailsFragment)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }
}