package com.example.movylistapp.data.network

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Gets.MOVIE)
    @Headers("Content-Type: application/json")
    suspend fun fetchMovieList(): Response<JsonObject>

}