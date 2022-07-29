package com.example.movylistapp.data.database

import androidx.room.TypeConverter

class MultimediaConverter {

    @TypeConverter
    fun fromMultimediaToString(multimedia: Multimedia): String {
        return multimedia.src
    }

    @TypeConverter
    fun fromStringToMultimedia(multimedia: String): Multimedia {
        return Multimedia(
            src = multimedia,
            type = "",
            width = "",
            height = ""
        )
    }
}