package com.programistamobile.mvvmapp.data

import androidx.lifecycle.LiveData
import com.programistamobile.mvvmapp.FilmsApplication
import com.programistamobile.mvvmapp.domain.FilmModel

class FilmsRepository {

    /* TODO Should be injected by DI :) */
    private val filmsDao: FilmsDao = FilmsApplication.database.filmDao()

    fun fetchAllFilms(): LiveData<List<FilmModel>> =
        filmsDao.fetchAllFilms()

    fun storeFilm(film: FilmModel) {
        filmsDao.storeFilm(film)
    }

    fun removeFilm(filmModel: FilmModel) {
        filmsDao.removeFilm(filmModel)
    }
}
