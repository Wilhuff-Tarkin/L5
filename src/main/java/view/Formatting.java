package view;

public interface Formatting {

    String ANSI_RESET = "\u001B[0m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_GREEN = "\u001b[32m";
    String ANSI_RED = "\u001b[31m";
    String GREEN_UNDERLINED = "\033[4;32m";

    static void printInYellowInLine(String message) {
        System.out.print(ANSI_YELLOW + message + ANSI_RESET);
    }

    static void printInGreenInLine(String message) {
        System.out.print(ANSI_GREEN + message + ANSI_RESET);
    }
    static void printInRed(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    static void printInGreenUnderlined(String message) {
        System.out.println(GREEN_UNDERLINED + message + ANSI_RESET);
    }

}
