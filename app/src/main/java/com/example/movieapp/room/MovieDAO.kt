package com.example.movieapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieapp.retrofit.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)


    @Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesinDB(): List<Movie>



}