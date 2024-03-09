package com.ahmedkenawy.moviesapp.core.mapper

interface Mapper<in I, out O> {
    fun map(model: I): O
}