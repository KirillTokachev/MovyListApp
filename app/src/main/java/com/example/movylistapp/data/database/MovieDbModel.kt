package com.example.movylistapp.data.database

import androidx.room.*

@Entity(tableName = "movie")
data class MovieDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "display_title")
    val displayTitle: String,
    @ColumnInfo(name = "summary_short")
    val summaryShort: String,
    @TypeConverters(MultimediaConverter::class)
    val multimedia: Multimedia
)

data class Multimedia(
    val type: String,
    val src: String,
    val width: String,
    val height: String
)