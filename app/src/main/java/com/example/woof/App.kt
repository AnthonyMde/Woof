package com.example.woof

import android.app.Application
import com.example.woof.di.initializeKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeKoin(this@App)
    }
}