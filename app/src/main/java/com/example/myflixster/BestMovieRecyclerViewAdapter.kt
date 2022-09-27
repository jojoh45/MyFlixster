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
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.best_movie, parent, false)
            return MovieViewHolder(view)
        }


        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: BestMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
            val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        }
}
