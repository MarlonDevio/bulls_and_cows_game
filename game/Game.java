package bullscows.game;

import bullscows.strategies.GameCodeGenerator;
import bullscows.ConsoleHandler;
import bullscows.Player;
import bullscows.ScoreKeeper;

import java.util.ArrayList;

import static bullscows.helpers.Helper.print;

/**
 * Class Game encapsulates the main game logic and interactions in the Bulls and Cows game.
 * It manages game setup, player interactions, and game flow.
 */
public class Game {
    private final int maxCodeLength = 36;  // The maximum length of the game code.
    private final int MIN_RANGE = 1;       // The minimum range value for game settings.
    private int maxSymbolRange = 36;       // The maximum range of symbols used in the game.
    private String code;                   // The secret game code.
    GameCodeGenerator gameCodeGenerator;   // The generator for the game code.
    ArrayList<Player> players;             // List of players in the game.
    ScoreKeeper scoreKeeper;               // Manages scoring for the game.
    ConsoleHandler consoleHandler;         // Handles console input/output for the game.

    /**
     * Default constructor for Game.
     * Initializes the game with default components.
     */
    public Game(){
        this(new GameCodeGenerator(), new ArrayList<>(), new ScoreKeeper(), new ConsoleHandler());
    }

    /**
     * Constructor for Game with custom components.
     *
     * @param gameCodeGenerator The generator for creating game codes.
     * @param players           List of players participating in the game.
     * @param scoreKeeper       The object managing scores throughout the game.
     * @param consoleHandler    The object handling console input/output.
     */
    public Game(GameCodeGenerator gameCodeGenerator, ArrayList<Player> players, ScoreKeeper scoreKeeper, ConsoleHandler consoleHandler){
        this.gameCodeGenerator = gameCodeGenerator;
        this.players = players;
        this.scoreKeeper = scoreKeeper;
        this.consoleHandler = consoleHandler;
    }

    /**
     * Initializes and starts the game setup.
     * It involves getting code length and symbol range from the user,
     * setting up the game code, and displaying initial information.
     */
    public void init(){
        // Gets the code length from the user, ensuring it is a digit within the defined range.
        int codeLength = consoleHandler.getNumericValueFromUser("Input the length of the secret code", this.MIN_RANGE, this.maxCodeLength);
        gameCodeGenerator.setCodeLength(codeLength);

        // Gets the range of symbols from the user, ensuring valid input within the defined range.
        int symbolLength = consoleHandler.getNumericValueFromUser("Input the number of possible symbols in the code:", this.MIN_RANGE, this.maxSymbolRange);
        gameCodeGenerator.setSymbolLength(symbolLength);

        // Displays the hidden code in the form of asterisks.
        consoleHandler.displayHiddenCode(gameCodeGenerator.getAsteriskFromCode());

        // Debugging lines - display the generated list of characters and the entered lengths.
        print(gameCodeGenerator.generateRandomNumberList().toString());
        System.out.println(codeLength);
        System.out.println(symbolLength);
    }
}
