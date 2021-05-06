package com.practice.mymovies.data.network

import com.practice.mymovies.data.network.response.MovieResponse
import retrofit2.http.GET

interface MovieServiceAPI {
    @GET("movies")
    suspend fun getMovies(): MovieResponse
}
