package bullscows;

import bullscows.controller.GameController;
import bullscows.model.CodeGenerator;
import bullscows.model.ScoreKeeper;
import bullscows.model.User;
import bullscows.view.View;

public class Main {
	public static void main(String[] args) {
		GameController gameController = new GameController(new View(),
				new User(), new CodeGenerator(), new ScoreKeeper());
		gameController.runGame();
	}
}
