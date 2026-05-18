package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.repository.Repository

class MovieViewModelFactory (private val repository: Repository): ViewModelProvider.Factory{
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MovieViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}