package com.practice.mymovies.data.network

import com.practice.mymovies.data.network.response.MovieResponse
import retrofit2.http.GET

interface MovieServiceAPI {

    companion object {
        val baseUrl = "https://movies-sample.herokuapp.com/api/"
    }

    @GET("movies")
    suspend fun getMovies(): MovieResponse
}
