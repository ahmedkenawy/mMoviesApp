package com.ahmedkenawy.moviesapp.features.list.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmedkenawy.moviesapp.features.list.domain.Movies

/**
 * Data Access Object (DAO) interface for interacting with the movies table.
 */
@Dao
interface MoviesDao {

    /**
     * Retrieves all movies from the movies table.
     *
     * @return A list of all movies stored in the database.
     */
    @Query("SELECT * FROM movies")
    suspend fun getAllItems(): List<Movies>

    /**
     * Inserts movies into the movies table.
     *
     * @param movies The list of movies to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movies>)
}