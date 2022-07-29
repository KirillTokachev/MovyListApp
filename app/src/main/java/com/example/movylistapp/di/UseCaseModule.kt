package com.example.movylistapp.di

import com.example.movylistapp.data.use_case_impl.GetMovieInfoUseCaseImpl
import com.example.movylistapp.data.use_case_impl.GetMovieListUseCaseImpl
import com.example.movylistapp.data.use_case_impl.SaveMovieUseCaseImpl
import com.example.movylistapp.domain.use_case.GetMovieInfoUseCase
import com.example.movylistapp.domain.use_case.GetMovieListUseCase
import com.example.movylistapp.domain.use_case.SaveMovieUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindGetMovieListUseCase(impl: GetMovieListUseCaseImpl): GetMovieListUseCase

    @Binds
    fun bindGetMovieInfoUseCase(impl: GetMovieInfoUseCaseImpl): GetMovieInfoUseCase

    @Binds
    fun bindSaveMovieUSeCase(impl: SaveMovieUseCaseImpl): SaveMovieUseCase
}