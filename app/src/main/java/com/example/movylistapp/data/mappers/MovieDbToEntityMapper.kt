package com.example.movylistapp.data.mappers

import com.example.movylistapp.data.database.MovieDbModel
import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.domain.model.Multimedia
import javax.inject.Inject

class MovieDbToEntityMapper @Inject constructor() : (MovieDbModel) -> Movie {

    override fun invoke(dbModel: MovieDbModel) =
        with(dbModel) {
            Movie(
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