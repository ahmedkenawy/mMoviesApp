package com.ahmedkenawy.moviesapp.features.list.presentaion.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.ahmedkenawy.moviesapp.MyApplication
import com.ahmedkenawy.moviesapp.core.base.BaseCoroutineDispatchers
import com.ahmedkenawy.moviesapp.core.base.BaseViewModel
import com.ahmedkenawy.moviesapp.features.list.data.MoviesRepository
import com.ahmedkenawy.moviesapp.features.list.presentaion.event.MoviesListEvent
import com.ahmedkenawy.moviesapp.network.process
import com.ahmedkenawy.moviesapp.utils.MovieDataManager
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * ViewModel responsible for managing data related to movie listing.
 * It interacts with the repository to fetch movies from local or remote data sources.
 * This ViewModel extends [BaseViewModel] and utilizes [MoviesListEvent] for event handling.
 *
 * @constructor Creates an instance of [MoviesViewModel].
 * @param moviesRepository Repository responsible for handling movie data.
 * @param dataManager Manager for handling movie-related data operations.
 * @param dispatchers Dispatcher for coroutines used in the ViewModel.
 */
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val dataManager: MovieDataManager,
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<MoviesListEvent>(dispatchers) {

    /**
     * Loads initial data when the ViewModel is created.
     */
    override fun loadInitialData() {
        fetchMovies()
    }

    /**
     * Fetches movies from either local or remote data sources based on synchronization status.
     */
    private fun fetchMovies() {
        if (dataManager.shouldSyncFromApi()) {
            fetchDataFromRemote()
        } else {
            fetchDataFromLocal()
        }
    }

    /**
     * Fetches movies from the local database.
     */
    private fun fetchDataFromLocal() {
        viewModelScope.launch {
            val localMovies = moviesRepository.fetchMoviesFromLocalDatabase()
            if (localMovies.isNotEmpty()) {
                // Data available in local database
                pushSingle(MoviesListEvent.FetchMovies(localMovies))
            } else {
                // No data available in local database
                fetchDataFromRemote()
            }
        }
    }

    /**
     * Fetches movies from the remote data source.
     */
    private fun fetchDataFromRemote() {
        viewModelScope.launch {
            moviesRepository.fetchMovies()
                .process {
                    // Handle successful data retrieval from remote source
                    pushSingle(MoviesListEvent.FetchMovies(it))
                    // Insert fetched data into the local database
                    moviesRepository.insertMovies(it)
                    dataManager.updateLastSyncTime()
                }
        }
    }
}
