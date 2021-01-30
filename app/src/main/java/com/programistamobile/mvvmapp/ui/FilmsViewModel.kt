package com.programistamobile.mvvmapp.ui

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.programistamobile.mvvmapp.data.FilmsRepository
import com.programistamobile.mvvmapp.domain.FilmModel

class FilmsViewModel(
    private val filmsRepository: FilmsRepository
) : ViewModel() {

    fun fetchAllFilmsLiveData(): LiveData<List<FilmModel>> =
        filmsRepository.fetchAllFilms()

    fun removeFilm(filmModel: FilmModel) {
        DeleteAsyncTask(filmsRepository).execute(filmModel)
    }

    fun storeFilm(title: String) {
        val filmModel = FilmModel(title)
        InsertAsyncTask(filmsRepository).execute(filmModel)
    }
}

private class InsertAsyncTask(private val repository: FilmsRepository) : AsyncTask<FilmModel, Void, Void>() {
    override fun doInBackground(vararg params: FilmModel): Void? {
        repository.storeFilm(params[0])
        return null
    }
}

private class DeleteAsyncTask(private val repository: FilmsRepository) : AsyncTask<FilmModel, Void, Void>() {
    override fun doInBackground(vararg params: FilmModel): Void? {
        repository.removeFilm(params[0])
        return null
    }
}
