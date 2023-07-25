package com.example.a1_navigation_activity;


public class Movie {

    private String movieName;
    private String writer;
    private String releaseDate;

    public Movie(String movieName, String writer, String releaseDate){
        this.movieName = movieName;
        this.writer = writer;
        this.releaseDate = releaseDate;

    }

    public String getMovieName() {
        return movieName;
    }

    public String getWriter() {
        return writer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
