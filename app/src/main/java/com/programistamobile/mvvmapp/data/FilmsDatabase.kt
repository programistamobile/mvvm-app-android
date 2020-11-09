package com.programistamobile.mvvmapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.programistamobile.mvvmapp.domain.FilmModel

@Database(entities = [(FilmModel::class)], version = 1)
abstract class FilmsDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmsDao
}
