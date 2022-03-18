package model;

import java.util.List;

public class MovieLibrary {

    private final List<Movie> allMovies;

    public MovieLibrary(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
}
