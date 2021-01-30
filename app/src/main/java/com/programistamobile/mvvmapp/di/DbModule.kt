package com.programistamobile.mvvmapp.di

import androidx.room.Room
import com.programistamobile.mvvmapp.data.DB_NAME
import com.programistamobile.mvvmapp.data.FilmsDao
import com.programistamobile.mvvmapp.data.FilmsDatabase
import com.programistamobile.mvvmapp.data.FilmsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            FilmsDatabase::class.java,
            DB_NAME
        ).build()
    }

    factory<FilmsDao> {
        get<FilmsDatabase>().filmDao()
    }
    factory<FilmsRepository> {
        FilmsRepository(filmsDao = get())
    }
}
