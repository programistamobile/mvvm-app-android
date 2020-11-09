package com.programistamobile.mvvmapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.programistamobile.mvvmapp.domain.FilmModel

@Dao
interface FilmsDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun storeFilm(filmModel: FilmModel)

  @Delete
  fun removeFilm(filmModel: FilmModel)

  @Query("SELECT * FROM films_table ORDER BY title ASC")
  fun fetchAllFilms(): LiveData<List<FilmModel>>
}
