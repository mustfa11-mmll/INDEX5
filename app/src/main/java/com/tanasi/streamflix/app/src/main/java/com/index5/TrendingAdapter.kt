package com.index5  // غيّر هذا حسب اسم الحزمة الفعلي

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.index5.model.Movie  // عدّل المسار حسب مكان Movie.kt
import com.index5.R

class TrendingAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<TrendingAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.imageMoviePoster)
        val title: TextView = view.findViewById(R.id.textMovieTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.title.text = movie.title

        Glide.with(holder.itemView.context)
            .load(movie.imageUrl)
            .into(holder.poster)
    }

    override fun getItemCount() = movies.size
    }
