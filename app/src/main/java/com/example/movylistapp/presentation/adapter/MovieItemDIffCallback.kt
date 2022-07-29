package com.example.movylistapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.movylistapp.domain.model.Movie

object MovieItemDIffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}