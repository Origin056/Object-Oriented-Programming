package com.example.movie_database;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        setupRecyclerView();
        loadMovieData();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        adapter = new MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }

    private void loadMovieData() {
        try {
            movies = JsonUtils.loadMoviesFromJson(this);

            if (movies == null || movies.isEmpty()) {
                showError("No movies found");
            } else {
                adapter.updateMovies(movies);
            }
        } catch (Exception e) {
            showError("Failed to load movies");
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}