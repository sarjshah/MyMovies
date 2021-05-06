package com.practice.mymovies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.practice.mymovies.R
import com.practice.mymovies.databinding.ItemMovieBinding
import com.practice.mymovies.model.Movie

class MovieListAdapter() : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {
    private val TAG = "MovieApp"
    var results = emptyList<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount() = results.size

    fun filterList(filteredActorList: MutableList<Movie>) {
        results = filteredActorList
        notifyDataSetChanged()
    }

    class MovieViewHolder(var movieItemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root) {

        private val TAG = "MovieApp"

        companion object {
            val LAYOUT = R.layout.item_movie

            fun from(parent: ViewGroup): MovieViewHolder {
                val binding = DataBindingUtil.inflate<ItemMovieBinding>(
                    LayoutInflater.from(parent.context),
                    LAYOUT, parent, false
                )
                return MovieViewHolder(binding)
            }
        }

        fun bind(itemMovie: Movie) {
            movieItemBinding.movie = itemMovie
        }
    }
}
