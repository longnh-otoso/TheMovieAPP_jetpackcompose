package com.example.movieapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.repository.Repository
import com.example.movieapp.retrofit.Movie
import kotlinx.coroutines.launch


class MovieViewModel(repository: Repository): ViewModel() {


    //on this state
    var movies by mutableStateOf<List<Movie>>(emptyList())
    private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
    private set

    var moviesFromDb by mutableStateOf<List<Movie>>(emptyList())
    private set


    init {
        viewModelScope.launch {
            try {
                val apiKey = "00ec801807cc237c1c21e08919f0297f"
                moviesFromApi = repository.getPopularMoviesOnline(apiKey)

                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi
            } catch (e: Exception) {

                // truong hop k lay duoc du lieu thi dung fetch data from room db

                // doc du luey
                movies = repository.getMoviesOffline()


            }
        }
    }



}