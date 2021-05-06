package com.practice.mymovies.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.mymovies.data.repository.MovieRepository
import com.practice.mymovies.data.repository.MovieRepositoryImpl
import com.practice.mymovies.model.Movie
import com.practice.mymovies.util.LoadingState
import kotlinx.coroutines.launch

interface MovieListContract {
    val movieList: LiveData<List<Movie>>
}

class MovieListViewModel : ViewModel(), MovieListContract {
    private val repository: MovieRepository = MovieRepositoryImpl()

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState> = _loadingState

    private val _movieList = MutableLiveData<List<Movie>>()
    override val movieList: LiveData<List<Movie>> = _movieList

    init {
        refreshMovieList()
    }

    fun refreshMovieList() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                _movieList.value = repository.fetchMovies()
                _loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
            }
        }
    }
}
