package com.example.movylistapp.domain.use_case

import com.example.movylistapp.domain.model.Movie
import com.google.gson.JsonObject
import retrofit2.Response

interface FetchMovieUseCase {

    suspend fun fetchMovie(): Response<JsonObject>
}