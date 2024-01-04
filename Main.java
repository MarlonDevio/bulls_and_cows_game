package bullscows;

import bullscows.controller.GameController;
import bullscows.model.CodeGenerator;
import bullscows.model.ScoreKeeper;
import bullscows.model.User;
import bullscows.view.View;

/**
 * The Main class is the entry point for the Bulls and Cows game.
 * It sets up the game by creating instances of necessary components and starts the game.
 */
public class Main {
	/**
	 * The main method initializes the game by creating instances of the View, User,
	 * CodeGenerator, and ScoreKeeper. It then creates a GameController and starts the game.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		GameController gameController = new GameController(new View(),
				new User(), new CodeGenerator(), new ScoreKeeper());
		gameController.runGame();
	}
}
