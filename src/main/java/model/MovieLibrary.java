package model;

import java.util.List;

public class MovieLibrary {

    private List <Movie> allMovies;
    private List <Actor> allActors;

    public List<Actor> getAllActors() {
        return allActors;
    }



    public MovieLibrary(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }


}
