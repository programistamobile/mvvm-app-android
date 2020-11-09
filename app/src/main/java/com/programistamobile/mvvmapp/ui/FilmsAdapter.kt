package com.programistamobile.mvvmapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.programistamobile.mvvmapp.R
import com.programistamobile.mvvmapp.domain.FilmModel
import kotlinx.android.synthetic.main.item_film.view.*

class FilmsAdapter(
    private val onRemoveFilmListener: OnRemoveFilmListener
) : RecyclerView.Adapter<FilmsAdapter.ItemViewHolder>() {

    private val items: MutableList<FilmModel> =
        mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setItems(items[position])
    }

    override fun getItemCount(): Int =
        items.size

    fun setItems(items: List<FilmModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setItems(film: FilmModel) {
            itemView.titleLabel.text = film.title
            itemView.removeButton.setOnClickListener { onRemoveFilmListener.invoke(film) }
        }
    }
}
