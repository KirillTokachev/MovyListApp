package com.example.movylistapp.di

import android.app.Application
import android.content.Context
import com.example.movylistapp.presentation.MovieDetailFragment
import com.example.movylistapp.presentation.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MovieModule::class,
        UseCaseModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: MovieListFragment)

    fun inject(fragment: MovieDetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}