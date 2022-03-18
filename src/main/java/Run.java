import controller.LibraryCreator;
import model.MovieLibrary;
import view.Menu;

import java.util.ArrayList;

public class Run {


    public static void main(String[] args)  {
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>(), new ArrayList<>());
        LibraryCreator.fillMoviesCollection(movieLibrary);
        LibraryCreator.fillActorsCollection(movieLibrary);

        Menu.mainMenu(movieLibrary);
    }


}


