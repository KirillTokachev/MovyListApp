package com.example.movylistapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMoviesList(): LiveData<List<MovieDbModel>>

    @Query("SELECT * FROM movie WHERE id == :id LIMIT 1")
    fun getMovieInfo(id: Long): LiveData<MovieDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movieList: List<MovieDbModel>)
}