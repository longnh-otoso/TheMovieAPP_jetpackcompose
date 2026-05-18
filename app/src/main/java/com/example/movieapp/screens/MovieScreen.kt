package com.example.movieapp.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.viewmodel.MovieViewModel

@Composable
fun MovieSreen(viewModel: MovieViewModel = viewModel()) {
    val moviesList = viewModel.movies
    MovieList(movies = moviesList)

}