package com.example.movylistapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movylistapp.databinding.ItemMovieInfoBinding
import com.example.movylistapp.domain.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter : ListAdapter<Movie, MovieItemViewHolder>(MovieItemDIffCallback) {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = ItemMovieInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movieList = getItem(position)
        with(holder.binding) {
            with(movieList) {
                Picasso.get().load(multimedia.src).into(ivMovie)
                tvMovieTitle.text = displayTitle
                tvDescription.text = summaryShort
                root.setOnClickListener {
                    onItemClickListener?.onClick(this)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(movie: Movie)
    }
}