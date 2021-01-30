package com.programistamobile.mvvmapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.programistamobile.mvvmapp.R
import com.programistamobile.mvvmapp.domain.FilmModel
import kotlinx.android.synthetic.main.activity_films.*
import org.koin.androidx.viewmodel.ext.android.viewModel

typealias OnRemoveFilmListener = (filmModel: FilmModel) -> Unit

class FilmsActivity : AppCompatActivity() {

    private val viewModel: FilmsViewModel by viewModel()
    private val adapter: FilmsAdapter by lazy {
        FilmsAdapter(
            onRemoveFilmListener = { viewModel.removeFilm(it) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        initRecyclerView()
        initListeners()
        initObservers()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initObservers() {
        viewModel.fetchAllFilmsLiveData().observe(this, Observer { films ->
            films?.let {
                adapter.setItems(films)
            }
        })
    }

    private fun initListeners() {
        saveButton.setOnClickListener {
            viewModel.storeFilm(titleInput.text.toString())
        }
    }
}