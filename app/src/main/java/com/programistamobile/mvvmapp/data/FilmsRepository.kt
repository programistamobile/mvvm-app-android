package com.programistamobile.mvvmapp.data

import androidx.lifecycle.LiveData
import com.programistamobile.mvvmapp.domain.FilmModel

class FilmsRepository(
    private val filmsDao: FilmsDao
) {

    fun fetchAllFilms(): LiveData<List<FilmModel>> =
        filmsDao.fetchAllFilms()

    fun storeFilm(film: FilmModel) {
        filmsDao.storeFilm(film)
    }

    fun removeFilm(filmModel: FilmModel) {
        filmsDao.removeFilm(filmModel)
    }
}
