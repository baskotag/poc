package com.poc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.poc.R
import com.poc.action.OnClickListener
import com.poc.databinding.FragmentHomeBinding
import com.poc.model.Movie
import com.poc.utility.AppConstant
import com.poc.utility.ServiceStates
import com.poc.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnClickListener {
    private val viewModel: MovieViewModel by viewModels()

    //    private val retrofitService = RetrofitService.getInstance()
//    private val appModule = AppModule
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
        viewModel.response.observe(viewLifecycleOwner)
        {

            binding.progressbar.isVisible =  it is ServiceStates.Loading && it.data.isNullOrEmpty()
//            progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
//            textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
//            textViewError.text = result.error?.localizedMessage

            //binding.progressbar.visibility = GONE
            viewModel.setAdapterData(it.data as ArrayList<Movie>, binding.recyclerView, this)
        }
    }

    override fun onclick(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstant.DATA_PASSING_KEY, movie)
        findNavController().graph.setStartDestination(R.id.detailsFragment)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }
}