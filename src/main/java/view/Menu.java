package view;

import controller.Controller;
import model.MovieLibrary;


public abstract class Menu implements Formatting {

    public static void printMenuOptions() {

        System.out.println("you have following options");
        System.out.println("choose one:");
        Formatting.printInYellow("1.");
        System.out.println(" insert two dates one after another to search for movies between them (both included");
        Formatting.printInYellow("2.");
        System.out.println(" learn about random movie");
        Formatting.printInYellow("3.");
        System.out.println(" insert name and surname of an actor to learn about movie he have starred in");
        Formatting.printInYellow("4.");
        System.out.println(" insert name  of a movie and look for some pictures");
    }

    public static void mainMenu(MovieLibrary movieLibrary) {
        printMenuOptions();
        int userChoice = Controller.getUserChoice();

        switch (userChoice) {
            case 1:
                Controller.displayAllMoviesBetweenDates(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 2:
                Controller.displayRandomMovie(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 3:
                Controller.displayAllMoviesWith(movieLibrary.getAllMovies());
                Menu.mainMenu(movieLibrary);
                break;
            case 4:
//                System.out.println(ANSI_YELLOW + "Bye, bye." + ANSI_RESET);
                Menu.mainMenu(movieLibrary);
                break;

            default: {
//                System.out.println(ANSI_RED + "Sorry, this data seems to be incorrect. Please try again." + ANSI_RESET);
            }


        }
    }

}
