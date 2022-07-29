package com.example.movylistapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Long,
    @SerializedName("display_title")
    val displayTitle: String,
    @SerializedName("summary_short")
    val summaryShort: String,
    val multimedia: Multimedia
)

data class Multimedia(
    val type: String,
    val src: String,
    val width: String,
    val height: String
)

