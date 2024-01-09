package bullscows.helpers;

import java.util.Scanner;

public class Helper {
    private static Scanner scanner = new Scanner(System.in);

    /*******
     * PRINTING UTILITIES
     ******/

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printf(String message) {
        System.out.printf(message);
    }

    /*********
     * INPUT READING UTILITIES
     *********/

    public static String readString() {
        return scanner.nextLine();
    }

    public static int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    /******
     *  CONVERTING UTILITIES
     ******/
    public static String convertIntToString(int num) {
        return num + "";
    }

    public static char convertNumToChar(int num) {
        return (char) num;
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            print("No characters allowed here, only numbers.");
        } return -1;
    }

    public static String convertCharToString(char character) {
        return String.valueOf(character);
    }

    public static int convertCharToNum(char character) {
        return Character.getNumericValue(character);
    }


}
