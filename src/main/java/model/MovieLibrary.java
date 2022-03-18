package model;

import java.util.List;

public class MovieLibrary {

    private List<Movie> allMovies;
    private List<Actor> allActors;

    public MovieLibrary(List<Movie> allMovies, List<Actor> allActors) {
        this.allMovies = allMovies;
        this.allActors = allActors;
    }

    public List<Actor> getAllActors() {
        return allActors;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
}
