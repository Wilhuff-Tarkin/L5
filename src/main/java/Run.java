import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import controller.LibraryCreator;
import model.*;
import view.Menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Run {


    public static void main(String[] args) throws IOException {
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());
        LibraryCreator.fillMoviesCollection(movieLibrary);
        LibraryCreator.fillActorsCollection(movieLibrary);

        Menu.mainMenu(movieLibrary);
    }




    }


