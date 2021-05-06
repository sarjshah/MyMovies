package com.practice.mymovies.data.repository

import com.practice.mymovies.data.network.response.Data
import com.practice.mymovies.data.network.response.MovieResponse
import com.practice.mymovies.model.Movie
import com.practice.mymovies.util.toMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieRepository {
    suspend fun fetchMovies(): List<Movie>
}

class MovieRepositoryImpl : MovieRepository {
    override suspend fun fetchMovies(): List<Movie> =
        withContext(Dispatchers.IO) {
            MovieResponse(listOf(Data("tstgenre", 1, "testposter", "testtitle", "2001"))).toMovie()
        }
}
