package bullscows.model;

import bullscows.helpers.Validator;

/**
 * The ScoreKeeper class manages the scoring of the Bulls and Cows game.
 * It calculates and keeps track of the number of bulls and cows for each guess.
 */
public class ScoreKeeper {
	private int bulls;
	private int cows;

	/**
	 * Checks the user's guess against the secret code and updates the scores of bulls and cows.
	 * A bull is counted when a guessed digit matches a code digit in the same position.
	 * A cow is counted when a guessed digit matches a code digit but in a different position.
	 *
	 * @param code  The secret code that needs to be guessed.
	 * @param guess The user's guess to be checked against the secret code.
	 */
	public void checkGuess(String code, String guess) {
		for (int i = 0; i < code.length(); i++) {
			if (Validator.isEqual(guess.charAt(i), code.charAt(i))) {
				bulls++;
			} else if (code.contains(String.valueOf(guess.charAt(i)))) {
				cows++;
			}
		}
	}

	/**
	 * Resets the scores of bulls and cows to zero.
	 * This is typically used at the start of a new game or a new guess.
	 */
	public void resetScore(){
		this.bulls = 0;
		this.cows = 0;
	}

	/**
	 * Retrieves the current number of bulls.
	 *
	 * @return The current number of bulls.
	 */
	public int getBulls() {
		return bulls;
	}

	/**
	 * Retrieves the current number of cows.
	 *
	 * @return The current number of cows.
	 */
	public int getCows() {
		return cows;
	}
}
