package bullscows.game;

import bullscows.GameCodeGenerator;
import bullscows.ConsoleHandler;
import bullscows.Player;
import bullscows.ScoreKeeper;

import java.util.ArrayList;

public class Game {
    private int maxCodeLength = 36;
    private final int MIN_RANGE = 1;
    private int maxSymbolRange = 26;
    private String code;
    private int codeLength;
    GameCodeGenerator gameCodeGenerator;
    ArrayList<Player> players;
    ScoreKeeper scoreKeeper;
    ConsoleHandler consoleHandler;

    public Game(){
        this(new GameCodeGenerator(), new ArrayList<>(), new ScoreKeeper(), new ConsoleHandler());
    }

    public Game(GameCodeGenerator gameCodeGenerator, ArrayList<Player>players, ScoreKeeper scoreKeeper, ConsoleHandler consoleHandler){
        this.gameCodeGenerator = gameCodeGenerator;
        this.players = players;
        this.scoreKeeper = scoreKeeper;
        this.consoleHandler =consoleHandler;
    }

    public void init(){

        /* Gets the codelength from the user, performs multiple checks - is digit - is in range and displays correct
        error messages */

        int codeLength = consoleHandler.getNumericValueFromUser("Input the length of the secret code", this.MIN_RANGE,
                this.maxCodeLength);

        // pass the codeLength to the gameCodeGenerator
        gameCodeGenerator.setCodeLength(codeLength);

        /*
        * Get amount range of symbols from user - Again - make use of getNumericValueFromUser, which continues
        * looping until the user provides a correct value.
        *
        *  */
        int symbolLength = consoleHandler.getNumericValueFromUser("Input the number of possible symbols in the code:",
                this.MIN_RANGE, this.maxSymbolRange);

        // pass the symbolLength to the gameCodeGenerator
        gameCodeGenerator.setSymbolLength(symbolLength);

        // Displays the hidden code as asterisks
        consoleHandler.displayHiddenCode(gameCodeGenerator.getAsteriskFromCode());

        System.out.println(codeLength);
        System.out.println(symbolLength);


    }
}
