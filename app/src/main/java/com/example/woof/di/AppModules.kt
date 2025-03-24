package com.example.woof.di

import android.content.Context
import com.example.data.di.dataModules
import com.example.domain.di.domainModules
import com.example.ui.di.uiModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun initializeKoin(context: Context) {
    startKoin {
        androidContext(context)
        modules(
            listOf(
                domainModules,
                dataModules,
                uiModules
            )
        )
    }
}