package com.ahmedkenawy.moviesapp.core.event

interface Event<out T> {
    val content: T
    fun getContent(asker: String): T?
}