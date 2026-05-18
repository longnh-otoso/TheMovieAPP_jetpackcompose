package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.room.util.TableInfo
import com.example.movieapp.repository.Repository
import com.example.movieapp.room.MoviesDB
import com.example.movieapp.screens.MovieSreen
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.viewmodel.MovieViewModel
import com.example.movieapp.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

      //  val database = MoviesDB.getInstance(applicationContext)

        val repository = Repository(applicationContext)

        val viewModelFactory = MovieViewModelFactory(repository)

        val movieViewModel = ViewModelProvider(this, factory = viewModelFactory)[MovieViewModel::class.java]




        setContent {
            MovieAppTheme {
                Column() {
                    HeaderComposable()
                    MovieSreen(viewModel = movieViewModel)
                }




            }
        }
    }
}

@Composable
fun HeaderComposable(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
            .fillMaxWidth())
    {
        Text(text = "Movie App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "List of popular movies",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )


    }
}