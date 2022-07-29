package com.example.movylistapp.domain.use_case

import androidx.lifecycle.LiveData
import com.example.movylistapp.domain.model.Movie

interface GetMovieInfoUseCase {

    fun getMovieInfo(id: Long): LiveData<Movie>
}