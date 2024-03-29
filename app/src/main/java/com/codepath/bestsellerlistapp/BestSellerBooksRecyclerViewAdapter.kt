package com.codepath.bestsellerlistapp
import android.content.Intent
import com.squareup.picasso.Picasso
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.bestsellerlistapp.R.id
import com.google.gson.Gson

class MovieAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mItem: Movie? = null
        val mMovieName: TextView = mView.findViewById(R.id.movie_name)
        val mMovieTitle: TextView = mView.findViewById(R.id.movie_title)
        val mMovieDescription: TextView = mView.findViewById(R.id.movie_description)
        val mMoviePoster: ImageView = mView.findViewById(R.id.movie_poster)

        fun bind(movie: Movie) {
            mMovieName.text = movie.name.toString()
            mMovieTitle.text = movie.title
            mMovieDescription.text = movie.description

            Glide.with(itemView.context)
                .load(movie.posterUrl)
                .into(mMoviePoster)

            mView.setOnClickListener {
                mListener?.onItemClick(movie)
                //
                mListener?.onItemClick(movie)

                // Create an Intent to start the MovieDetailActivity
                val intent = Intent(itemView.context, MovieDetailsActivity::class.java)
                // Pass necessary data to the detail activity
                intent.putExtra("movie_name", movie.name)
                intent.putExtra("movie_title", movie.title)
                intent.putExtra("movie_description", movie.description)
                intent.putExtra("movie_poster_url", movie.posterUrl)
                // Add any additional data you want to pass

                itemView.context.startActivity(intent)


            }
            //
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class Glide {
    val gson = Gson()

}
