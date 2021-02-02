package com.kg.malikov.mukminapp

import android.app.Application
import com.kg.malikov.mukminapp.di.networkModule
import com.kg.malikov.mukminapp.di.repositoryModule
import com.kg.malikov.mukminapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(mutableListOf(repositoryModule, networkModule, viewModelModule,))

        }
    }
}