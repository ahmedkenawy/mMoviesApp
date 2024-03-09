package com.ahmedkenawy.moviesapp.features.list.presentaion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ahmedkenawy.moviesapp.core.base.BaseFragment
import com.ahmedkenawy.moviesapp.databinding.FragmentMoviesListBinding
import com.ahmedkenawy.moviesapp.features.list.domain.Movies
import com.ahmedkenawy.moviesapp.features.list.presentaion.adapter.MoviesAdapter
import com.ahmedkenawy.moviesapp.features.list.presentaion.event.MoviesListEvent
import com.ahmedkenawy.moviesapp.features.list.presentaion.viewmodel.MoviesViewModel
import com.ahmedkenawy.moviesapp.utils.extentions.navigate
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment responsible for displaying a list of movies.
 * It initializes and binds views, sets up view models, and handles events related to movie listing.
 * This fragment extends [BaseFragment] and implements [MoviesListEvent] for event handling.
 *
 * @constructor Creates an instance of [MoviesList].
 */
@AndroidEntryPoint
class MoviesList : BaseFragment<MoviesListEvent>() {

    /**
     * Adapter for displaying movies in a RecyclerView.
     */
    private lateinit var moviesAdapter: MoviesAdapter

    /**
     * Tag used for logging and debugging purposes.
     */
    override val mTag = "MoviesList"

    /**
     * View binding instance for accessing views in the layout.
     */
    override val mBinding by lazy {
        FragmentMoviesListBinding.inflate(layoutInflater)
    }

    /**
     * View model instance for handling business logic related to movie listing.
     */
    override val mViewModel by viewModels<MoviesViewModel>()

    /**
     * Called when the view is created. Responsible for setting up views and initializing UI components.
     *
     * @param view The view that was created.
     * @param savedInstanceState The saved instance state of the fragment.
     */
    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        // Custom logic can be implemented here if needed
    }

    /**
     * Sets up views and initializes UI components.
     */
    override fun setUpViews() {
        // Custom logic for setting up views can be implemented here
    }

    /**
     * Renders events related to movie listing.
     *
     * @param event The event to be rendered.
     */
    override fun renderEvent(event: MoviesListEvent) {
        when (event) {
            is MoviesListEvent.FetchMovies -> displayMovies(event.movies)
        }
    }

    /**
     * Displays a list of movies.
     *
     * @param movies List of movies to be displayed.
     */
    private fun displayMovies(movies: List<Movies?>) {
        moviesAdapter = MoviesAdapter() { position, movies ->
            navigate(
                MoviesListDirections.actionMoviesListToMovieDetailsScreen(movies)
            )
        }
        mBinding.rvMovies.adapter = moviesAdapter
        moviesAdapter.submitList(movies)
    }
}
