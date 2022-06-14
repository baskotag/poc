package com.poc.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.poc.R
import com.poc.databinding.FragmentDetailsBinding
import com.poc.model.Movie
import com.poc.utility.AppConstant.DATA_PASSING_KEY

class DetailsFragment : Fragment() {
    lateinit var movie: Movie
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bundle = arguments
        movie = bundle?.get(DATA_PASSING_KEY) as Movie
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text = movie.name
        binding.details.text = movie.desc
        Glide.with(binding.placeImage)
            .load(movie.imageUrl)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(binding.placeImage)
    }
}