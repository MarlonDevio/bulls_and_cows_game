package bullscows.controller;

import bullscows.model.CodeGenerator;
import bullscows.model.ScoreKeeper;
import bullscows.model.User;
import bullscows.view.View;

/**
 * The GameController class coordinates the game logic for Bulls and Cows.
 * It manages the game loop, initializing the game, and handling user interactions.
 */
public class GameController {
	private View view;
	private User user;
	private ScoreKeeper scoreKeeper;
	private CodeGenerator codeGenerator;

	/**
	 * Constructs a GameController with the necessary components.
	 *
	 * @param view          The view component responsible for user interaction.
	 * @param user          The user playing the game.
	 * @param codeGenerator The generator for the secret code.
	 * @param scoreKeeper   The keeper of the game score.
	 */
	public GameController(View view, User user, CodeGenerator codeGenerator,
	                      ScoreKeeper scoreKeeper) {
		this.view = view;
		this.user = user;
		this.codeGenerator = codeGenerator;
		this.scoreKeeper = scoreKeeper;
	}

	/**
	 * Starts and runs the game loop. Initializes the game and controls the game flow.
	 */
	public void runGame() {
		initializeGame();
		startGameLoop();
	}

	/**
	 * Initializes the game by setting the secret code and displaying the start message.
	 */
	private void initializeGame() {
		int codeLength = view.getLengthOfCode("Please, enter the secret code's length");
		int possibleSymbols = view.getNumberOfPossibleSymbols("Input the number of possible symbols in the code");
		codeGenerator.setCode(codeLength);
		System.out.println(codeGenerator.getCode());
		view.displayStartOfGameMessage();
	}

	/**
	 * Contains the main game loop, which runs until the user guesses the code correctly.
	 * Manages each turn of the game, including getting the user's guess and updating the score.
	 */
	private void startGameLoop() {
		while (true) {
			if (user.getBulls() == codeGenerator.getCode().length()) {
				view.displayEndOfGameMessage();
				break;
			}
			scoreKeeper.resetScore();
			view.displayTurns();
			user.setGuess(view.getGuess());
			scoreKeeper.checkGuess(codeGenerator.getCode(), user.getGuess());
			user.setBullsAndCows(scoreKeeper.getBulls(), scoreKeeper.getCows());
			if (user.getBulls() == 0 && user.getCows() == 0) {
				System.out.println("Grade: None.");
				continue;
			}
			view.displayScore(user.getBulls(), user.getCows());
		}
	}
}
