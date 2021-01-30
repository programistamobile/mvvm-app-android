package com.programistamobile.mvvmapp

import android.app.Application
import com.programistamobile.mvvmapp.di.dbModule
import com.programistamobile.mvvmapp.di.filmsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class FilmsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@FilmsApplication)
            modules(provideModules())
        }
    }

    private fun provideModules(): List<Module> =
        listOf(
            dbModule,
            filmsModule
        )
}
