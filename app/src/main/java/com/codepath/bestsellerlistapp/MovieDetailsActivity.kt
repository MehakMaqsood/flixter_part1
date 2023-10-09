package com.codepath.bestsellerlistapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.codepath.bestsellerlistapp.Movie
class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Retrieve movie data from the intent
        val movie = intent.getSerializableExtra("movie_data") as Movie

        // Populate the UI elements with movie details
        val movieNameTextView = findViewById<TextView>(R.id.movie_name_detail)
        val movieTitleTextView = findViewById<TextView>(R.id.movie_title_detail)
        val movieDescriptionTextView = findViewById<TextView>(R.id.movie_description_detail)
        val moviePosterImageView = findViewById<ImageView>(R.id.movie_poster_detail)

        movieNameTextView.text = movie.name
        movieTitleTextView.text = movie.title
        movieDescriptionTextView.text = movie.description

        // Load movie poster using Glide or any image loading library
        Glide.with(this)
            .load(movie.posterUrl)
            .into(moviePosterImageView)

        // Load additional actor data and descriptions as needed
        val actors = movie.actors
        // Access actor data and populate the UI accordingly
    }
}
