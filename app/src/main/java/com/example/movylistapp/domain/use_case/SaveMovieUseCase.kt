package com.example.movylistapp.domain.use_case

import com.example.movylistapp.domain.model.Movie

interface SaveMovieUseCase {

    suspend fun saveMovie(movies: List<Movie>)
}