package com.example.movieapp.repository

import com.example.movieapp.retrofit.Movie
import com.example.movieapp.retrofit.RetrofitInstance

class Repository {
    suspend fun getPopularMoviesOnline(apiKey: String): List<Movie> {
        val response = RetrofitInstance.api.getPopularMovies(apiKey)
        return response.results

    }
}