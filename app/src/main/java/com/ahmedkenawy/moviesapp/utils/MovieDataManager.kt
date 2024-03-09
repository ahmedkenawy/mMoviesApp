package com.ahmedkenawy.moviesapp.utils

import android.content.SharedPreferences
import java.util.concurrent.TimeUnit.HOURS
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton class responsible for managing movie data synchronization.
 * It provides methods to determine if syncing from the API is necessary and to update the last sync time.
 */
@Singleton
class MovieDataManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        // Key for storing last sync time in SharedPreferences
        private const val LAST_SYNC_TIME = "lastSyncTime"

        // Sync interval in milliseconds (4 hours)
        private var SYNC_INTERVAL = HOURS.toMillis(4)
    }

    /**
     * Checks if synchronization from the API is required based on the elapsed time since the last sync.
     *
     * @return True if synchronization is required, false otherwise.
     */
    fun shouldSyncFromApi(): Boolean {
        val lastSyncTime = sharedPreferences.getLong(LAST_SYNC_TIME, 0)
        val currentTime = System.currentTimeMillis()
        val elapsedTime = currentTime - lastSyncTime
        return elapsedTime >= SYNC_INTERVAL
    }

    /**
     * Updates the last sync time in SharedPreferences with the current system time.
     */
    fun updateLastSyncTime() {
        val editor = sharedPreferences.edit()
        editor.putLong(LAST_SYNC_TIME, System.currentTimeMillis())
        editor.apply()
    }
}
