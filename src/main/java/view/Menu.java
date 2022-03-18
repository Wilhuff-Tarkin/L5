package view;

import controller.Controller;
import model.MovieLibrary;


public abstract class Menu implements Formatting {

    public static void printMenuOptions() {
        Formatting.printInGreenUnderlined("WELCOME TO MOVIE LIBRARY");
        System.out.println("Choose one from the options below:");
        Formatting.printInYellowInLine("1.");
        System.out.println("Search for movies released between two dates (years)");
        Formatting.printInYellowInLine("2.");
        System.out.println("Lookup information about random movie from library");
        Formatting.printInYellowInLine("3.");
        System.out.println("Search for all movies featuring specific movie star");
        Formatting.printInYellowInLine("4.");
        System.out.println("Lookup additional information in Internet Movie DataBase (IMDb.com)");
    }

    public static void mainMenu(MovieLibrary movieLibrary) {
        Controller controller = new Controller();
        printMenuOptions();
        int userChoice = controller.getUserChoice();

        switch (userChoice) {
            case 1:
                controller.showAllMoviesBetweenDates(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 2:
                controller.showRandomMovie(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 3:
                controller.showAllMoviesWith(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 4:
                controller.searchInIMDB();
                Menu.mainMenu(movieLibrary);
                break;
            default: {
                Formatting.printInRed("Something went wrong.");
            }
        }
    }
}
