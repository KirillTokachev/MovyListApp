package com.example.movylistapp.di

import com.example.movylistapp.data.network.ApiFactory
import com.example.movylistapp.data.network.ApiService
import com.example.movylistapp.data.use_case_impl.FetchMovieUseCaseImpl
import com.example.movylistapp.domain.use_case.FetchMovieUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NetworkModule {

    @Binds
    fun bindFetchMovieUseCase(impl: FetchMovieUseCaseImpl): FetchMovieUseCase

    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideApiServise(): ApiService {
            return ApiFactory.apiService
        }
    }
}