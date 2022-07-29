package com.example.movylistapp.data.use_case_impl

import androidx.lifecycle.LiveData
import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.domain.repository.Repository
import com.example.movylistapp.domain.use_case.GetMovieListUseCase
import javax.inject.Inject

class GetMovieListUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetMovieListUseCase {

    override fun getMovieList(): LiveData<List<Movie>> {
        return repository.getMovieList()
    }
}