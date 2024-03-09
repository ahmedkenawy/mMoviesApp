package com.ahmedkenawy.moviesapp.utils

import com.ahmedkenawy.moviesapp.BuildConfig


class Constants {

    object Configuration {
        const val FLOW_REPLAY_CACHE = 999
        const val FLOW_BUFFER_CAPACITY = 99
    }

    object Network {
        const val BASE_URL_KEY = "BASE_URL"
        const val CONNECT_TIMEOUT = 20L
        const val READ_TIMEOUT = 20L
        const val WRITE_TIMEOUT = 20L
        const val HEADER_CONTENT_TYPE = "Content-Type"
        const val HEADER_CONTENT_TYPE_VALUE = "application/json"
        const val AUTHRIZATION_TYPE = "api_key"
        const val AUTHRIZATION_TYPE_VALUE = BuildConfig.API_KEY
    }

    object Intent {
        const val MOVIE_NAME = "movie"
    }
}