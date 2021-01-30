package com.programistamobile.mvvmapp.di

import com.programistamobile.mvvmapp.ui.FilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filmsModule = module {
    viewModel {
        FilmsViewModel(filmsRepository = get())
    }
}
