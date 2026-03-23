package com.example.movie_database;

public class Movie
{
    private String title;
    private Integer year;
    private String genre;
    private String posterResource;

    public Movie(String title, Integer year, String genre, String posterResource){
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown Title";
        this.year = (year != null) ? year : 0;
        this.genre = (genre != null && !genre.isEmpty()) ? genre : "Unknown Genre";
        this.posterResource = (posterResource != null) ? posterResource : "";
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPosterResource() {
        return posterResource;
    }

}