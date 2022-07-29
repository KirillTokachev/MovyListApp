package com.example.movylistapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.movylistapp.data.database.MovieDao
import com.example.movylistapp.data.mappers.MovieDbToEntityMapper
import com.example.movylistapp.data.mappers.MovieEntityToMovieDb
import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val movieDbToEntityMapper: MovieDbToEntityMapper,
    private val movieEntityToMovieDb: MovieEntityToMovieDb
) : Repository {

    override fun getMovieList(): LiveData<List<Movie>> {
        return Transformations.map(movieDao.getMoviesList()) {
            it.map { movieDb ->
                movieDbToEntityMapper(movieDb)
            }
        }
    }

    override fun getMovieInfo(id: Long): LiveData<Movie> {
        return Transformations.map(movieDao.getMovieInfo(id)) {
            movieDbToEntityMapper(it)
        }
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        movieDao.insertMovieList(movies.map(movieEntityToMovieDb))
    }
}