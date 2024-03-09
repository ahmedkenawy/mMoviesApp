package com.ahmedkenawy.moviesapp.features.list.presentaion.event

import com.ahmedkenawy.moviesapp.features.list.domain.Movies

/**
 * Sealed class representing events related to movie listing.
 */
sealed class MoviesListEvent {
    /**
     * Event indicating the need to fetch movies.
     *
     * @param movies List of movies to be fetched.
     */
    data class FetchMovies(val movies: List<Movies?>) : MoviesListEvent()
}
