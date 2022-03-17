package controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Actor;
import model.Movie;
import model.MovieLibrary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class LibraryCreator {

    public static void fillMoviesCollection(MovieLibrary movieLibrary) {

        List <Movie> movies = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPath = "src/main/resources/movies.json";

            movies = mapper.readValue(
                    new File(jsonPath),
                    new TypeReference<>(){});

            movies.forEach(x -> System.out.println(x.toString()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Movie movie : movies) {
            movieLibrary.getAllMovies().add(movie);
        }
    }


    public static void fillActorsCollection(MovieLibrary movieLibrary) {

        HashMap <Actor, List <String>> mapa = new HashMap<>();

        for (Movie oneMovie : movieLibrary.getAllMovies()) {


            int size = oneMovie.getActors().size();
            System.out.println("przed petlą");
            System.out.println(oneMovie.getActors().toString());

            for (int i = 0; i < size; i++) {

                List <String> movietitles = new ArrayList<>();
                movietitles.add(oneMovie.getTitle());
                mapa.put(oneMovie.getActors().get(i),movietitles);

            }
            System.out.println(mapa);


//            System.out.println(wystepuja.toString());

            }


        }

    }



