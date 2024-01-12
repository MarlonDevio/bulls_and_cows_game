package bullscows.refactored.helpers;

import java.util.Scanner;

/**
 * The Helper class provides various utility methods for printing, input
 * reading, and converting data types.
 */
public class Helper {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prints a message to the console.
     *
     * @param message the message to be printed
     */
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * Prints a formatted message to the console.
     *
     * @param message the formatted message to be printed
     */
    public static void printf(String message) {
        System.out.printf(message);
    }

    /**
     * Reads a string from the console.
     *
     * @return the string read from the console
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer from the console.
     *
     * @return the integer read from the console
     */
    public static int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Converts an integer to a string.
     *
     * @param num the integer to be converted
     * @return the string representation of the integer
     */
    public static String convertIntToString(int num) {
        return num + "";
    }

    /**
     * Converts a number to a character.
     *
     * @param num the number to be converted
     * @return the character representation of the number
     */
    public static char convertNumToChar(int num) {
        return (char) num;
    }

    /**
     * Converts a string to an integer.
     *
     * @param input the string to be converted
     * @return the integer representation of the string, or -1 if the string cannot
     *         be converted
     */
    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            print("No characters allowed here, only numbers.");
        }
        return -1;
    }

    /**
     * Converts a character to a string.
     *
     * @param character the character to be converted
     * @return the string representation of the character
     */
    public static String convertCharToString(char character) {
        return String.valueOf(character);
    }

    /**
     * Converts a character to a number.
     *
     * @param character the character to be converted
     * @return the numeric value of the character
     */
    public static int convertCharToNum(char character) {
        return Character.getNumericValue(character);
    }
}
