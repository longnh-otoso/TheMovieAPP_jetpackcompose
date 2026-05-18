package com.example.movieapp.repository

import android.content.Context
import com.example.movieapp.retrofit.Movie
import com.example.movieapp.retrofit.RetrofitInstance
import com.example.movieapp.room.MoviesDB

class Repository(context: Context) {

    //Fletching data from API
    suspend fun getPopularMoviesOnline(apiKey: String): List<Movie> {
        val response = RetrofitInstance.api.getPopularMovies(apiKey)
        return response.results

    }

    //fletching data from DB
    private val db= MoviesDB.getInstance(context)
    private val movieDao = db.movieDao

    suspend fun getMoviesOffline(): List<Movie>{
        return movieDao.getAllMoviesinDB()
    }
    suspend fun insertMoviesIntoDB(movies: List<Movie>){
        return movieDao.insertMoviesList(movies)
    }

    // goi 1 movie duy nhat
    suspend fun insertMovieIntoDB(movie: Movie){
        return movieDao.insertMovie(movie)
    }


}