package controller;

import model.Movie;
import view.Formatting;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {

    public void showAllMoviesBetweenDates(List<Movie> allMovies) {
        int[] scope = getTwoDatesFromUser();
        Stream<Movie> allMoviesStream = allMovies.stream();
        Arrays.sort(scope);

        List<Movie> result = allMoviesStream
                .filter(movie -> movie.getDate() >= scope[0])
                .filter(movie -> movie.getDate() <= scope[1])
                .collect(Collectors.toList());

        if (result.size() == 0) {
            notifyAboutNegativeSearchResult(scope);
        } else {
            notifyAboutPositiveSearchResult(result.size());

            for (Movie movie : result) {
                System.out.println(movie.toString());
            }
        }
    }

    public void showRandomMovie(List<Movie> allMovies) {
        Random random = new Random();
        System.out.println(allMovies.get(random.nextInt(allMovies.size())));
    }

    public void showAllMoviesWith(List<Movie> allMovies) {
        Stream<Movie> allMoviesStream = allMovies.stream();

        System.out.println("Please enter first name of movie star");
        String firstName = getStringFromUser();
        System.out.println("Please enter surname of movie star");
        String surname = getStringFromUser();

        List<Movie> result = allMoviesStream
                .filter(movie -> movie.getActors().stream().anyMatch(actor -> actor.getFirstName().equals(firstName)))
                .filter(movie -> movie.getActors().stream().anyMatch(actor -> actor.getLastName().equals(surname)))
                .collect(Collectors.toList());

        if (result.size() == 0) {
            notifyAboutNegativeSearchResult(firstName, surname);
        } else {
            notifyAboutPositiveSearchResult(result.size());

            for (Movie movie : result) {
                Formatting.printInGreenInLine("==> ");
                System.out.println(movie.getTitle());
            }
            System.out.println();
        }
    }

    public void searchInIMDB() {
        System.out.print("Please enter ");
        Formatting.printInGreenInLine("title of a movie");
        System.out.print(" or a ");
        Formatting.printInGreenInLine("name of someone");
        System.out.println(" from movie industry (opens new browser window)");
        String title = getStringFromUser();
        title = title.replace(' ', '+');
        String url = "https://www.imdb.com/find?q=" + title;

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[1-4]")) {
            System.out.println("Please stick to options: 1, 2, 3 or 4");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int[] getTwoDatesFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a earliest release year (included in results)");
        int startingYear = scanner.nextInt();
        System.out.println("Please enter an latest release year (included in results)");
        int endYear = scanner.nextInt();
        return new int[]{startingYear, endYear};
    }

    private String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[A-Za-z\\s]*");
        while (!scanner.hasNext(pattern)) {
            Formatting.printInRed("nie tak");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    private void notifyAboutPositiveSearchResult(int size) {
        System.out.println();
        Formatting.printInYellowInLine(String.valueOf(size));
        System.out.print(" movie(s) matching search conditions found:");
        System.out.println();
    }

    private void notifyAboutNegativeSearchResult(String name, String surname) {
        System.out.println("Sorry, library do not have any movies with " + name + " " + surname);
    }

    private void notifyAboutNegativeSearchResult(int[] scope) {
        System.out.println("Sorry did not found anything between " + scope[0] + " and " + scope[1]);
    }
}
