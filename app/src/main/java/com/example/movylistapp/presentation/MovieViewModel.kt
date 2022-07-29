package com.example.movylistapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movylistapp.data.mappers.JsonMapper
import com.example.movylistapp.data.use_case_impl.FetchMovieUseCaseImpl
import com.example.movylistapp.data.use_case_impl.GetMovieInfoUseCaseImpl
import com.example.movylistapp.data.use_case_impl.GetMovieListUseCaseImpl
import com.example.movylistapp.data.use_case_impl.SaveMovieUseCaseImpl
import kotlinx.coroutines.*
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val fetchMovieUseCaseImpl: FetchMovieUseCaseImpl,
    private val getMovieListUseCaseImpl: GetMovieListUseCaseImpl,
    private val getMovieInfoUseCaseImpl: GetMovieInfoUseCaseImpl,
    private val jsonMapper: JsonMapper,
    private val saveMovieUseCaseImpl: SaveMovieUseCaseImpl
) : ViewModel() {

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error("Exception handled: ${throwable.localizedMessage}")
    }

    val movieList = getMovieListUseCaseImpl.getMovieList()

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    fun getDetailInfoMovie(id: Long) = getMovieInfoUseCaseImpl.getMovieInfo(id)

    private suspend fun loadData() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = fetchMovieUseCaseImpl.fetchMovie()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        saveMovieUseCaseImpl.saveMovie(jsonMapper(it))
                    }
                } else {
                    error("Error : ${response.message()}")
                }
            }
        }
    }
}