package com.example.movie_database;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils
{
    public static List<Movie> loadMoviesFromJson(Context context){
        List<Movie> movies = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("movies.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i < jsonArray.length(); i++){
                try {
                    JSONObject obj = jsonArray.getJSONObject(i);

                    String title = obj.optString("title", null);
                    int year = obj.has("year") ? obj.getInt("year") : null;
                    String genre = obj.optString("genre", null);
                    String poster = obj.optString("poster", null);

                    movies.add(new Movie(title, year, genre, poster));
                } catch (Exception e) {
                    handleJsonException(e);
                }
            }
        } catch (Exception e) {
            handleJsonException(e);
            return null;
        }

        return movies;
    }

    public static void handleJsonException(Exception e) {
        Log.e("JSON_ERROR", "Error: " + e.getMessage());
    }
}