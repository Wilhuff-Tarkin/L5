package model;

import java.util.List;

public class Movie {

    private String title;
    private Director director;
    private Genre genre;
    private int date;
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Movie(String title, Director director, Genre genre, int date, List<Actor> actors) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.date = date;
        this.actors = actors;
    }

    public Movie() {
    }

    public Movie(String title, Director director, Genre genre, int date) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.date = date;
    }
}