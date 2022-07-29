package com.example.movylistapp.data.mappers

import com.example.movylistapp.data.database.MovieDbModel
import com.example.movylistapp.data.database.Multimedia
import com.example.movylistapp.domain.model.Movie
import javax.inject.Inject

class MovieEntityToMovieDb @Inject constructor() : (Movie) -> MovieDbModel {

    override fun invoke(entity: Movie) =
        with(entity) {
            MovieDbModel(
                id = id,
                displayTitle = displayTitle,
                summaryShort = summaryShort,
                multimedia = Multimedia(
                    multimedia.type,
                    multimedia.src,
                    multimedia.width,
                    multimedia.height
                )
            )
        }
}