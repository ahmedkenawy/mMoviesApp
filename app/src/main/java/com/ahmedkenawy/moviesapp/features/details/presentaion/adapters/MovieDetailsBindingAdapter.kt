package com.ahmedkenawy.moviesapp.features.details.presentaion.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.ahmedkenawy.moviesapp.R

@BindingAdapter("setMovieImage")
fun setMovieImage(imageView: ImageView, poster: String?) {
    imageView.load("https://image.tmdb.org/t/p/original/$poster") {
        placeholder(R.drawable.ic_refresh) // Placeholder image while loading
        transformations(RoundedCornersTransformation()) // Apply circle crop transformation
        error(R.drawable.error_place_holder)  // error place holder image
        crossfade(true) // Enable crossfade animation
    }
}