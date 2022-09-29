package com.example.myflixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myflixster.R.id

class BestMovieRecyclerViewAdapter(
    private val movies: List<BestMovie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<BestMovieRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
        {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.best_movie, parent, false)
            return MovieViewHolder(view)
        }


        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: BestMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
            val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
            val mMovieImage: ImageView = mView.findViewById<View>(id.movie_image) as ImageView

            override fun toString(): String {
                return mMovieTitle.toString() + " '" + mMovieDescription.text + "'"
            }
        }


        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]
            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieDescription.text = movie.description

            holder.mView.setOnClickListener {
                holder.mItem?.let { movie ->
                    mListener?.onItemClick(movie)
                }
            }
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/" + movie.moveImageUrl)
                .centerCrop()
                .into(holder.mMovieImage)
        }

        override fun getItemCount(): Int {
            return movies.size
        }
}
