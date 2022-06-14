package com.poc.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poc.R
import com.poc.action.OnClickListener
import com.poc.model.Movie
import com.poc.databinding.MovieAdapterBinding

class MovieAdapter(private var items: ArrayList<Movie>, private val action: OnClickListener) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieAdapterBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            action.onclick(items[position])
        }
    }

    override fun getItemCount() = items.size
    class MyViewHolder(private val binding: MovieAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Movie) {
            binding.viewModel = data
            binding.executePendingBindings()
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(placeImage: ImageView, url: String) {
            Glide.with(placeImage)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(placeImage)
        }
    }

}