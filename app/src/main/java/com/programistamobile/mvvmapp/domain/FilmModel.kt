package com.programistamobile.mvvmapp.domain

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films_table")
data class FilmModel(
    @PrimaryKey @NonNull val title: String
)
