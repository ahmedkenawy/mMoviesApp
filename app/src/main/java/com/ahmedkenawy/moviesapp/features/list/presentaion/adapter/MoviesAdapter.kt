package com.ahmedkenawy.moviesapp.features.list.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.ahmedkenawy.moviesapp.R
import com.ahmedkenawy.moviesapp.databinding.ItemMoviesBinding
import com.ahmedkenawy.moviesapp.features.list.domain.Movies

/**
 * Adapter for displaying movies in a RecyclerView.
 *
 * @param onMovieClickListener Callback for handling movie item clicks.
 */
class MoviesAdapter(
    private val onMovieClickListener: (Int, Movies) -> Unit
) :
    ListAdapter<Movies, MoviesAdapter.MoviesViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<Movies>() {

        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * ViewHolder for movie items.
     *
     * @param binding View binding for the item layout.
     */
    inner class MoviesViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds movie data to the view.
         *
         * @param position The position of the item in the RecyclerView.
         * @param movies The movie data to bind.
         */
        fun bind(position: Int, movies: Movies) {
            with(binding) {
                movies.let {
                    ivPoster.load("https://image.tmdb.org/t/p/original/${it.poster_path}") {
                        placeholder(R.drawable.ic_refresh)
                        transformations(RoundedCornersTransformation())
                        error(R.drawable.error_place_holder)
                        crossfade(true)
                    }
                    tvTitle.text = it.title
                    tvTotalVotes.text = it.vote_count.toString()
                    tvTotalVotesAverage.text = it.vote_average.toString()
                }

                btnViewMore.setOnClickListener {
                    onMovieClickListener(position, movies)
                }
            }
        }
    }

    /**
     * Creates a new ViewHolder for movie items.
     *
     * @param parent The parent ViewGroup.
     * @param viewType The type of the view.
     * @return A new instance of [MoviesViewHolder].
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    /**
     * Binds movie data to the ViewHolder.
     *
     * @param holder The ViewHolder to bind.
     * @param position The position of the item in the RecyclerView.
     */
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(position, it)
        }
    }
}