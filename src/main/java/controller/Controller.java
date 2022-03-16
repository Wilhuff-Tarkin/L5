package controller;

import model.MovieLibrary;
import view.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public abstract class Controller {

    public static int getUserChoice(){

            Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNext("[1-4]")) {
                System.out.println("Please stick to options: 1, 2, 3 or 4");
                scanner.next();
            }
            return scanner.nextInt();
        }


    public static void displayRandomMovie (){



    }

    public static void displayAllMoviesBetweenDates (){
        System.out.println("dwa miedzy datami");
    }


    public static void displayAllMoviesWith (){

    }

    public static void searchMovies (){

        String picturesFromMovie = "https://www.google.com/search?tbm=isch&q=" ;


        try {
            Desktop.getDesktop().browse(new URI(picturesFromMovie));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }

    }
}
