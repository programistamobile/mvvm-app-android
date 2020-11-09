package com.programistamobile.mvvmapp

import android.app.Application
import androidx.room.Room
import com.programistamobile.mvvmapp.data.FilmsDatabase

class FilmsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            FilmsDatabase::class.java,
            "films_database"
        ).build()
    }

    companion object {
        lateinit var database: FilmsDatabase
    }
}
