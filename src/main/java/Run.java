import controller.LibraryCreator;
import model.MovieLibrary;
import view.Menu;

public class Run {

    public static void main(String[] args)  {
        MovieLibrary movieLibrary = LibraryCreator.parseJsonSource();
        Menu.mainMenu(movieLibrary);
    }
}


