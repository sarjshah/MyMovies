package com.practice.mymovies.util

import com.practice.mymovies.data.network.response.MovieResponse
import com.practice.mymovies.model.Movie

fun MovieResponse.toMovie(): List<Movie> {
    return this.data.map {
        Movie(it.genre, it.id, it.poster, it.title, it.year)
    }
}
