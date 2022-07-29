package com.example.movylistapp.data.use_case_impl

import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.domain.repository.Repository
import com.example.movylistapp.domain.use_case.SaveMovieUseCase
import javax.inject.Inject

class SaveMovieUseCaseImpl @Inject constructor(
    private val repository: Repository
) : SaveMovieUseCase {

    override suspend fun saveMovie(movies: List<Movie>) {
        repository.saveMovies(movies)
    }
}