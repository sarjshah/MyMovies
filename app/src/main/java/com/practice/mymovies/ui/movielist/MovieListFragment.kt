package com.practice.mymovies.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.mymovies.R
import com.practice.mymovies.databinding.FragmentMovieListBinding
import com.practice.mymovies.model.Movie
import com.practice.mymovies.ui.adapter.MovieListAdapter
import com.practice.mymovies.util.LoadingState

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private var movieList = emptyList<Movie>()
    private lateinit var movieListAdapter: MovieListAdapter
    private val movieListViewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        setupRecyclerView()
        setupRecyclerViewData()

        binding.btnClear.setOnClickListener {
            binding.etSearch.text.clear()
        }

        movieListViewModel.loadingState.observe(
            viewLifecycleOwner,
            Observer { loadingState ->
                when (loadingState.status) {
                    LoadingState.Status.FAILED -> {
                        Toast.makeText(
                            context,
                            loadingState.msg,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    LoadingState.Status.RUNNING -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                        binding.pbMovieList.visibility = View.VISIBLE
                    }

                    LoadingState.Status.SUCCESS -> {
                        Toast.makeText(context, "Loaded", Toast.LENGTH_SHORT).show()
                        binding.pbMovieList.visibility = View.GONE
                    }
                }
            }
        )

        return binding.root
    }

    private fun setupRecyclerViewData() {
        movieListViewModel.movieList.observe(
            viewLifecycleOwner,
            Observer {
                movieList = it
                movieListAdapter.results = movieList
            }
        )
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            movieListAdapter = MovieListAdapter()
            adapter = movieListAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}
