package com.example.movylistapp.data.use_case_impl

import com.example.movylistapp.data.network.ApiService
import com.example.movylistapp.domain.use_case.FetchMovieUseCase
import com.google.gson.JsonObject
import retrofit2.Response
import javax.inject.Inject

class FetchMovieUseCaseImpl @Inject constructor(
    private val apiService: ApiService
) : FetchMovieUseCase {

    override suspend fun fetchMovie(): Response<JsonObject> {
        return apiService.fetchMovieList()
    }
}