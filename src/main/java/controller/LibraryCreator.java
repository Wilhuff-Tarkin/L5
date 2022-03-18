package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Movie;
import model.MovieLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class LibraryCreator {

    public static MovieLibrary parseJsonSource() {
        List<Movie> movies = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPath = "src/main/resources/movies.json";

            movies = mapper.readValue(
                    new File(jsonPath),
                    new TypeReference<>() {
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new MovieLibrary(movies);
    }
}



