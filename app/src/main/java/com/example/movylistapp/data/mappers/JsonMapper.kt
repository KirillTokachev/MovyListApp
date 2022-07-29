package com.example.movylistapp.data.mappers

import com.example.movylistapp.domain.model.Movie
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class JsonMapper @Inject constructor() : (JsonObject) -> List<Movie> {

    override fun invoke(jsonObject: JsonObject): List<Movie> {
        val jsonArray = jsonObject["results"]
        val typeToken = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(jsonArray, typeToken)
    }
}