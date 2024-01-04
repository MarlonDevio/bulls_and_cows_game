package bullscows.helpers;

import java.util.Scanner;

/**
 * The CollectInput class provides static methods for collecting user input
 * from the console. It encapsulates all Scanner interactions.
 */
public class CollectInput {
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Asks a question to the user and returns the user's string input.
	 *
	 * @param question The question to be displayed to the user.
	 * @return The user's input as a string.
	 */
	public static String getStringInput(String question){
		System.out.println(question);
		return getStringInput();
	}

	/**
	 * Returns the user's string input without displaying a question.
	 *
	 * @return The user's input as a string.
	 */
	public static String getStringInput(){
		return scanner.nextLine();
	}

	/**
	 * Returns the user's input as an integer without displaying a question.
	 *
	 * @return The user's input as an integer.
	 */
	public static int getIntInput(){
		return Integer.parseInt(scanner.nextLine());
	}

	/**
	 * Asks a question to the user and returns the user's integer input.
	 *
	 * @param question The question to be displayed to the user.
	 * @return The user's input as an integer.
	 */
	public static int getIntInput(String question){
		System.out.println(question);
		return getIntInput();
	}

	/**
	 * Prints a message to the console.
	 *
	 * @param message The message to be printed.
	 */
	public static void printMessage(String message){
		System.out.println(message);
	}
}
