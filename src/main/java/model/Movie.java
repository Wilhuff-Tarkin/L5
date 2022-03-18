package model;

import java.util.List;

public class Movie {

    private String title;
    private Director director;
    private String genre;
    private int date;
    private List<Actor> actors;

    public Movie(String title, Director director, String genre, int date, List<Actor> actors) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.date = date;
        this.actors = actors;
    }

    public Movie() {
    }

    public int getDate() {
        return date;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getFormattedActorsList() {
        StringBuilder result = new StringBuilder();
        for (Actor actor : actors) {
            result.append(actor.getFirstName());
            result.append(" ");
            result.append(actor.getLastName());
            result.append(", ");
        }
        return String.valueOf(result.substring(0, result.length() - 2));
    }

    @Override
    public String toString() {
        return "\r\n" +
                "title: " + title + "\r\n" +
                "director: " + director + "\r\n" +
                "genre: " + genre + "\r\n" +
                "date: " + date + "\r\n" +
                "actors: " + getFormattedActorsList() + "\r\n";
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }
}