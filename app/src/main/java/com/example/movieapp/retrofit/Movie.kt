package com.example.movieapp.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterpath: String,


)
