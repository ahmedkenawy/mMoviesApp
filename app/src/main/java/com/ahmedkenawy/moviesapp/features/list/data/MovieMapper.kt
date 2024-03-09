package com.ahmedkenawy.moviesapp.features.list.data

import com.ahmedkenawy.moviesapp.core.mapper.Mapper
import com.ahmedkenawy.moviesapp.features.list.data.remote.response.MoviesDto
import com.ahmedkenawy.moviesapp.features.list.domain.Movies
import javax.inject.Inject

/**
 * Mapper class responsible for mapping from [MoviesDto] to [Movies].
 */
class MovieMapper @Inject constructor() : Mapper<MoviesDto, Movies> {

    /**
     * Maps a [MoviesDto] object to a [Movies] object.
     * @param model The input [MoviesDto] object.
     * @return The mapped [Movies] object.
     */
    override fun map(model: MoviesDto): Movies {
        return Movies(
            id = model.id,
            overview = model.overview,
            popularity = model.popularity,
            poster_path = model.poster_path,
            title = model.title,
            vote_average = model.vote_average,
            vote_count = model.vote_count
        )
    }
}
