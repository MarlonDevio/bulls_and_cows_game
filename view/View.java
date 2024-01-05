package bullscows.view;

import bullscows.helpers.CollectInput;
import bullscows.helpers.Validator;

/**
 * The View class manages the user interface for the Bulls and Cows game.
 * It handles displaying messages, collecting user inputs, and showing game progress.
 */
public class View {
	private int turns;

	public void displayAsterisks(int codeLength){
		for(int i = 0; i<codeLength;i++){
			System.out.print("*");
		}
	}
	public static void displayNumbers(int maxRangeOfLetters){
		String chars = Validator.isHigherThan10(11) ? "a-" : "";
		System.out.print("(0-9, "+chars+"-"+maxRangeOfLetters);
	}
	/**
	 * Prompts the user for the length of the secret code and validates the input.
	 * The length cannot exceed 10 due to the limitation of unique digits (0-9).
	 *
	 * @param question The prompt message for the user.
	 * @return The validated length of the secret code.
	 */
	public int getLengthOfCode(String question) {
		int length = CollectInput.getIntInput(question);
		if (length > 36) {
			CollectInput.printMessage("Error: Can't generate a secret number with a length of 11 because there " +
					"aren't enough unique digits.");
			return getLengthOfCode(question);
		}
		return length;
	}

	public int getNumberOfPossibleSymbols(String question){
		int symbolNumbers =  CollectInput.getIntInput(question);
		if(symbolNumbers > 36) {
			CollectInput.printMessage("Error: can't generate a secret number with more than 26 symbols");
			return getNumberOfPossibleSymbols(question);
		}
		return symbolNumbers;
	}

	/**
	 * Displays a message at the start of the game.
	 */
	public void displayStartOfGameMessage() {
		CollectInput.printMessage("Okay, let's start a game!");
	}

	/**
	 * Displays a congratulatory message when the game ends.
	 */
	public void displayEndOfGameMessage() {
		CollectInput.printMessage(
				"Congratulations! You guessed the secret code.");
	}

	/**
	 * Displays the current turn number in the game.
	 */
	public void displayTurns() {
		turns++;
		System.out.println("Turn " + this.turns + ":");
	}

	/**
	 * Collects and returns the user's guess.
	 *
	 * @return The user's guess as a string.
	 */
	public String getGuess() {
		return CollectInput.getStringInput();
	}

	/**
	 * Displays the score of the current guess in terms of bulls and cows.
	 *
	 * @param bulls The number of bulls (correct digits in the correct position).
	 * @param cows  The number of cows (correct digits in the wrong position).
	 */
	public void displayScore(int bulls, int cows) {
		String bullScore = convertScore(bulls, "bull");
		String cowScore = convertScore(cows, "cow");
		String scoreMessage =
				"Grade: " + bullScore + (bulls > 0 && cows > 0 ? " and " : "") +
						cowScore;
		System.out.println(scoreMessage.trim());
	}

	/**
	 * Converts a numerical score into a formatted string.
	 *
	 * @param score  The score to be converted.
	 * @param animal The type of score ("bull" or "cow").
	 * @return A formatted string representing the score.
	 */
	private String convertScore(int score, String animal) {
		return score > 0 ? score + " " + animal + (score > 1 ? "s" : "") : "";
	}
}
