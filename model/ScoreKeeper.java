package bullscows.model;

import bullscows.helpers.Validator;

public class ScoreKeeper {
	private int bulls;
	private int cows;

	public void checkGuess(String code, String guess) {
		for (int i = 0; i < code.length(); i++) {
			if (Validator.isEqual(guess.charAt(i), code.charAt(i))) {
				bulls++;
			} else if ( code.contains(String.valueOf(guess.charAt(i)))){
				cows++;
					}
				}
			}

	public void resetScore(){
		this.bulls = 0;
		this.cows = 0;
	}

	public int getBulls() {
		return bulls;
	}

	public int getCows() {
		return cows;
	}
}
