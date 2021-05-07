package com.practice.mymovies.data.repository

import com.practice.mymovies.data.network.MovieServiceAPI
import com.practice.mymovies.data.network.response.Data
import com.practice.mymovies.data.network.response.MovieResponse
import com.practice.mymovies.model.Movie
import com.practice.mymovies.util.toMovie
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieRepository {
    suspend fun fetchMovies(): List<Movie>
}

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieServiceAPI
) : MovieRepository {
    override suspend fun fetchMovies(): List<Movie> =
        withContext(Dispatchers.IO) {
            service.getMovies().toMovie()
        }

    fun getData() = MovieResponse(
        listOf(
            Data("History", 1, "https://goo.gl/1zUyyq", "testtitle", "2001"),
            Data(
                "Animation",
                2,
                "https://image.tmdb.org/t/p/" +
                    "w370_and_h556_bestv2/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg",
                "testtitle",
                "2001"
            ),
            Data(
                "Action",
                3,
                "https://image.tmdb.org/t/p/" +
                    "w370_and_h556_bestv2/coss7RgL0NH6g4fC2s5atvf3dFO.jpg",
                "testtitle",
                "2001"
            ),
            Data(
                "Fantasy",
                4,
                "https://image.tmdb.org/t/p/" +
                    "w370_and_h556_bestv2/5vHssUeVe25bMrof1HyaPyWgaP.jpg",
                "testtitle",
                "2001"
            ),
            Data(
                "Drama",
                5,
                "https://image.tmdb.org/t/p/" +
                    "w370_and_h556_bestv2/gri0DDxsERr6B2sOR1fGLxLpSLx.jpg",
                "testtitle",
                "2001"
            ),
            Data(
                "Sci-Fi",
                6,
                "https://raw.githubusercontent.com/cesarferreira/" +
                    "sample-data/master/public/posters/038025.jpg",
                "testtitle",
                "2001"
            )
        )
    )
}
