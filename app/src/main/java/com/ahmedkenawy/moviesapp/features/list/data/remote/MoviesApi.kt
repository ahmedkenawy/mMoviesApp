package com.ahmedkenawy.moviesapp.features.list.data.remote

import com.ahmedkenawy.moviesapp.BuildConfig
import com.ahmedkenawy.moviesapp.features.list.data.remote.response.MoviesDto
import com.ahmedkenawy.moviesapp.network.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Interface for defining movie-related API endpoints.
 */
interface MoviesApi {

    /**
     * Fetches popular movies from the API.
     *
     * @param apiKey The API key required for authentication.
     * @return An [ApiResponse] containing a list of [MoviesDto].
     */
    @GET("movie/popular")
    suspend fun fetchMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY): ApiResponse<MutableList<MoviesDto>>
}