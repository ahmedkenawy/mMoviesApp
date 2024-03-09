package com.ahmedkenawy.moviesapp.features.details.presentaion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.ahmedkenawy.moviesapp.R
import com.ahmedkenawy.moviesapp.core.base.BaseFragment
import com.ahmedkenawy.moviesapp.databinding.FragmentMovieDetailsScreenBinding
import com.ahmedkenawy.moviesapp.features.details.presentaion.viewmodel.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
/**
 * Fragment for displaying details of a movie.
 * This fragment extends [BaseFragment] and does not handle any specific event type.
 */
@AndroidEntryPoint
class MovieDetailsScreen : BaseFragment<Any>() {

    /**
     * Tag used for logging and debugging purposes.
     */
    override val mTag = "MovieDetailsScreen"

    /**
     * View binding instance for accessing views in the layout.
     */
    override val mBinding by lazy {
        FragmentMovieDetailsScreenBinding.inflate(layoutInflater)
    }

    /**
     * View model instance for managing data related to movie details.
     */
    override val mViewModel by viewModels<MovieDetailsViewModel>()

    /**
     * Called when the view is created. Responsible for setting up views and initializing UI components.
     *
     * @param view The view that was created.
     * @param savedInstanceState The saved instance state of the fragment.
     */
    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        // Bind the view model to the view
        mBinding.viewModel = mViewModel
    }

    /**
     * Sets up views and initializes UI components.
     */
    override fun setUpViews() {
        // Custom logic for setting up views can be implemented here
    }
}
