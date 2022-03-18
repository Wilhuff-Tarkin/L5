package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Actor;
import model.Movie;
import model.MovieLibrary;

import java.io.File;
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

//            movies.forEach(x -> System.out.println(x.toString()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Movie movie : movies) {
            movieLibrary.getAllMovies().add(movie);
        }
    }


    public static void fillActorsCollection(MovieLibrary movieLibrary) {

        HashMap <Actor, List <String>> mapa = new HashMap<>();
        List <String> moviesStarred = new ArrayList<>();

        for (Movie oneMovie : movieLibrary.getAllMovies()) {

            for {actor actor : one movei get.acotrs}
            {
            dodaj do mapy aktora

                    i dodaj film do tego aktora
                    chyba ze juz go ma
            }

            int size = oneMovie.getActors().size();

            for (int i = 0; i < size; i++) {

                Actor tmpActor = oneMovie.getActors().get(i);

                if (moviesStarred.contains(oneMovie.getTitle())){
                    System.out.println("juz mam ten film");
                } else if (heStarredInIt(oneMovie.getActors(), tmpActor)) {
                    moviesStarred.add(oneMovie.getTitle());
                }
                mapa.put(tmpActor, moviesStarred);
            }
        }
        System.out.println(mapa);
   }

    private static boolean heStarredInIt(List<Actor> actors, Actor actor) {
        return actors.contains(actor);
    }


}



