package com.ahmedkenawy.moviesapp.features.details.presentaion.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.ahmedkenawy.moviesapp.core.base.BaseCoroutineDispatchers
import com.ahmedkenawy.moviesapp.core.base.BaseViewModel
import com.ahmedkenawy.moviesapp.features.list.domain.Movies
import com.ahmedkenawy.moviesapp.utils.Constants.Intent.MOVIE_NAME
import com.ahmedkenawy.moviesapp.utils.databinding.ObservableString
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * ViewModel responsible for managing data related to movie details.
 * This ViewModel extends [BaseViewModel] and does not handle any specific event type.
 */
@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<Any>(dispatchers) {

    /**
     * Movie details retrieved from the saved state.
     */
    val movieName: Movies? = savedStateHandle.get<Movies>(MOVIE_NAME)

    /**
     * Observable field for the movie poster path.
     */
    val poster = ObservableString()

    /**
     * Observable field for the movie title.
     */
    val title = ObservableString()

    /**
     * Observable field for the total votes of the movie.
     */
    val totalVotes = ObservableString()

    /**
     * Observable field for the average votes of the movie.
     */
    val totalAvgVotes = ObservableString()

    /**
     * Observable field for the overview of the movie.
     */
    val overView = ObservableString()

    /**
     * Loads initial data when the ViewModel is created.
     */
    override fun loadInitialData() {
        loadMovieDetails()
    }

    /**
     * Loads movie details into observable fields.
     */
    private fun loadMovieDetails() {
        movieName?.let {
            title.set(it.title)
            totalVotes.set(it.vote_count.toString())
            totalAvgVotes.set(it.vote_average.toString())
            overView.set(it.overview)
            poster.set(it.poster_path)
        }
    }
}