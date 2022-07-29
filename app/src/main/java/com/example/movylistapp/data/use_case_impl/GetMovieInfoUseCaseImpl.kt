package com.example.movylistapp.data.use_case_impl

import androidx.lifecycle.LiveData
import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.domain.repository.Repository
import com.example.movylistapp.domain.use_case.GetMovieInfoUseCase
import javax.inject.Inject

class GetMovieInfoUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetMovieInfoUseCase {

    override fun getMovieInfo(id: Long): LiveData<Movie> {
        return repository.getMovieInfo(id)
    }
}