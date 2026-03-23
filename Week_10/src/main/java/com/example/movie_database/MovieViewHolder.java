package com.example.movie_database;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder
{
    private TextView titleTextView, yearTextView, genreTextView;
    private ImageView posterImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.title);
        yearTextView = itemView.findViewById(R.id.year);
        genreTextView = itemView.findViewById(R.id.genre);
        posterImageView = itemView.findViewById(R.id.poster);
    }

    public void bind(Movie movie){
        titleTextView.setText(movie.getTitle());
        yearTextView.setText(String.valueOf(movie.getYear()));
        genreTextView.setText(movie.getGenre());

        if (movie.getPosterResource().isEmpty()) {
            posterImageView.setImageResource(R.drawable.placeholder);
        } else {
            int resId = itemView.getContext().getResources().getIdentifier(movie.getPosterResource(), "drawable", itemView.getContext().getPackageName());
            if (resId == 0) {
                posterImageView.setImageResource(R.drawable.placeholder);
            } else {
                posterImageView.setImageResource(resId);
            }
        }
    }
}

