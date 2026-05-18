package com.example.movieapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.retrofit.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {

    abstract val movieDao: MovieDAO

    companion object {
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDB::class.java,
                        "movies_database"
                    ).build()

                }
                INSTANCE = instance
                return instance

            }

        }
    }
}


