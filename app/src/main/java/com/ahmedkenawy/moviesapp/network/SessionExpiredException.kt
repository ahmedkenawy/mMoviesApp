package com.ahmedkenawy.moviesapp.network

import com.ahmedkenawy.moviesapp.MyApplication
import com.ahmedkenawy.moviesapp.R
import java.io.IOException

class SessionExpiredException : IOException() {

    // You can send any message whatever you want from here.
    override val message: String
        get() = MyApplication.instance.resources.getString(R.string.network_session_has_expired)
}