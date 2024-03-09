package com.ahmedkenawy.moviesapp.features.list.data

import com.ahmedkenawy.moviesapp.features.list.data.local.MoviesDatabase
import com.ahmedkenawy.moviesapp.features.list.data.remote.MoviesApi
import com.ahmedkenawy.moviesapp.features.list.domain.Movies
import com.ahmedkenawy.moviesapp.network.NetworkRouter
import com.ahmedkenawy.moviesapp.network.mapList
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val api: MoviesApi,
    private val moviesDatabase: MoviesDatabase,
    private val movieMapper: MovieMapper
) {

    suspend fun fetchMovies() =
        NetworkRouter.invokeCall { api.fetchMovies() }
            .mapList(movieMapper)


    suspend fun fetchMoviesFromLocalDatabase(): List<Movies> =
        moviesDatabase.moviesDao().getAllItems()


    suspend fun insertMovies(competitions: List<Movies>) =
        moviesDatabase.moviesDao().insertMovies(competitions)
}