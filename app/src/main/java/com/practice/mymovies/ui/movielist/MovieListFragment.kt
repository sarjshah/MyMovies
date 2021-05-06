package com.practice.mymovies.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.practice.mymovies.R
import com.practice.mymovies.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding =
            DataBindingUtil.inflate<FragmentMovieListBinding>(
                inflater, R.layout.fragment_movie_list, container, false
            )

        return binding.root
    }
}
