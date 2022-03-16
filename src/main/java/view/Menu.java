package view;

import controller.Controller;

public abstract class Menu {

    public static void printMenuOptions() {

        System.out.println("you have following options");
        System.out.println("choose one:");
        System.out.println("1. insert two dates one after another to search for movies between them (both included");
        System.out.println("2. learn about random movie");
        System.out.println("3. insert name and surname of an actor to learn about movie he have starred in");
        System.out.println("4. insert name  of a movie and look for some pictures");
    }

    public static void mainMenu(int userChoice) {
        printMenuOptions();


        switch (userChoice) {
            case 1:
                Controller.displayAllMoviesBetweenDates();
                Menu.mainMenu(Controller.getUserChoice());
                break;
            case 2:
//                company.printDataOfAllEmployees();
                Menu.mainMenu(Controller.getUserChoice());
                break;
            case 3:
//                company.addEmployee(UserInputHandler.getEmployee(company));
                Menu.mainMenu(Controller.getUserChoice());
                break;
            case 4:
//                System.out.println(ANSI_YELLOW + "Bye, bye." + ANSI_RESET);
                Menu.mainMenu(Controller.getUserChoice());
                break;

            default: {
//                System.out.println(ANSI_RED + "Sorry, this data seems to be incorrect. Please try again." + ANSI_RESET);
            }


        }
    }

}
