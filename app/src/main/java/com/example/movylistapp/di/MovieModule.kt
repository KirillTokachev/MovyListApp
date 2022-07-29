package com.example.movylistapp.di

import android.app.Application
import com.example.movylistapp.data.database.AppDataBase
import com.example.movylistapp.data.database.MovieDao
import com.example.movylistapp.data.repository.RepositoryImpl
import com.example.movylistapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MovieModule {

    @Binds
    fun bindMovieRepository(impl: RepositoryImpl): Repository

    companion object {

        @JvmStatic
        @Provides
        fun provideMovieDao(application: Application): MovieDao {
            return AppDataBase.getInstance(application).getMovieDao()
        }
    }
}