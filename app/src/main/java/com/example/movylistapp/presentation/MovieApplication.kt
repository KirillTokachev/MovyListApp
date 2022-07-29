package com.example.movylistapp.presentation

import android.app.Application
import com.example.movylistapp.di.DaggerApplicationComponent

class MovieApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this, applicationContext)
    }
}