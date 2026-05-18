package com.example.movieapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.movieapp.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) {
            movie -> MovieItem(movie)
        }
    }
}

