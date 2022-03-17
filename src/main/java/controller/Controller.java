package controller;

import model.Actor;
import model.Movie;
import view.Formatting;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Controller {



    public static int getUserChoice(){

        Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNext("[1-4]")) {
                System.out.println("Please stick to options: 1, 2, 3 or 4");
                scanner.next();
            }
            return scanner.nextInt();
        }


    public static void displayRandomMovie(List<Movie> allMovies){

        Random random = new Random();


        System.out.println(allMovies.get(random.nextInt(allMovies.size())));


    }

    public static void displayAllMoviesBetweenDates(List<Movie> allMovies){


        int [] scope = getDatesFromUser();

        Stream<Movie> allMovi = allMovies.stream();

        List<Movie> result = allMovi
                .filter(movie -> movie.getDate()>=scope[0])
                .filter(movie -> movie.getDate()<=scope[1])
                .collect(Collectors.toList());

        if (result.size() == 0) {
            printNegativeResult(scope);
        } else {
            System.out.println();
            System.out.println("Found " + result.size() + " movies matching search conditions:");

            for (Movie movie : result) {
                System.out.println();
                movie.toString();
            }
        }

    }

    private static void printNegativeResult(int[] scope) {
    }

    private static int [] getDatesFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give a starting year (4 digits)");
        int startingYear = scanner.nextInt();

        System.out.println("Please give a end year (4 digits)");
        int endYear = scanner.nextInt();

        return new int[]{startingYear, endYear};
    }


    public static void displayAllMoviesWith (List<Movie> allMovies){
        System.out.println("Give me a name of an actor");
        String name = getActorFromUSer();
        System.out.println("Give me a surname of an actor");
        String surname = getActorFromUSer();

        Actor lookedFor = new Actor(name, surname);
        Actor tmp;
        List <Movie> result = new ArrayList<>();




        if (result.size() == 0) {
            System.out.println("nit found");;
        } else {
            System.out.println();
            System.out.println("Found " + result.size() + " movies matching search conditions:");

            for (Movie movie : result) {
                System.out.println();
                movie.toString();
            }
        }

    }

    private static String getActorFromUSer() {
        Scanner scanner = new Scanner(System.in);


        while (!scanner.hasNext("[a-zA-Z]+")) {
            Formatting.printInRed("nie tak");
            scanner.next();
        }
        return scanner.next();


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
