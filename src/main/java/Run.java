import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import model.Actor;
import model.Director;
import model.Genre;
import model.Movie;
import view.Menu;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Run {



    public static void main(String[] args) {
        Menu.printMenuOptions();
        Menu.mainMenu(Controller.getUserChoice());
    }



    private static void probazapisu() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Movie movie = new Movie("Martwica Mozgu", new Director(), new Genre(), 1999, List.of(new Actor()));

        objectMapper.writeValue(new File("src/main/resources/movie1.json"), movie);

    }


    public static void probaodczytu(){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
           Movie movie = objectMapper.readValue("src/main/resources/movies.json", Movie.class);
            System.out.println(movie.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
