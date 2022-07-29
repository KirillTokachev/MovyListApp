package com.example.movylistapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.movylistapp.domain.model.Movie

interface Repository {

    fun getMovieList(): LiveData<List<Movie>>

    fun getMovieInfo(id: Long): LiveData<Movie>

    suspend fun saveMovies(movies: List<Movie>)
}