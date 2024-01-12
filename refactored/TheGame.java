package bullscows.refactored;

import bullscows.refactored.codegeneration.CodeGenerator;
import bullscows.refactored.codegeneration.codegenerationstrategies.CodeGenerationStrategy;
import bullscows.refactored.codegeneration.codegenerationstrategies.SecretMessageGenerator;
import bullscows.refactored.coderequirementhandling.View;
import bullscows.refactored.helpers.Helper;
import bullscows.refactored.helpers.Validator;
import bullscows.refactored.scorehandling.GameScoreView;
import bullscows.validationStrategies.BullValidator;
import bullscows.validationStrategies.CowValidator;
import bullscows.validationStrategies.IValidateAble;

import java.util.List;

import static bullscows.refactored.helpers.Helper.print;

/**
 * TheGame class represents the game logic for the Bulls and Cows game.
 * It handles the generation of secret code, user input, validation, and
 * scoring.
 */
public class TheGame {
    // Constants
    public final static int MIN_RANGE = 1;
    public final static int MAX_RANGE = 36;

    // Code generation strategies and validation
    CodeGenerationStrategy<String> codeGenerationStrategy;
    CodeGenerationStrategy<List<Character>> listCodeGenerationStrategy;
    IValidateAble<String, List<Character>, Integer> validateAble;

    // View for displaying messages and scores
    View view;
    // Game scores
    int bulls;
    int cows;
    int turns;
    // Secret code and message
    private List<Character> secretCode;
    private String secretMessage;

    /**
     * Constructs a new instance of TheGame.
     *
     * @param listCodeGenerationStrategy The code generation strategy for
     *                                   generating
     *                                   a list of characters.
     * @param codeGenerationStrategy     The code generation strategy for
     *                                   generating
     *                                   a string code.
     * @param view                       The view for displaying messages and
     *                                   scores.
     */
    public TheGame(CodeGenerator listCodeGenerationStrategy,
                   SecretMessageGenerator codeGenerationStrategy, View view) {
        this.listCodeGenerationStrategy = listCodeGenerationStrategy;
        this.codeGenerationStrategy = codeGenerationStrategy;
        this.view = view;

        startGame();
    }

    /**
     * Starts the game by resetting scores, handling user code requirement, and
     * displaying the score view.
     */
    public void startGame() {
        this.bulls = 0;
        this.cows = 0;
        this.turns = 0;
        handleCodeRequirementFromUser();
        handleScoreView();
    }

    /**
     * Handles the user's code requirement by getting the code length and symbol
     * length from the user,
     * setting the secret code and message, and displaying them.
    */
    private void handleCodeRequirementFromUser() {

        // Get the codeLength
        int codeLength = view.getNumericValueFromUser(
                "Input the length of the secret code:", MIN_RANGE, MAX_RANGE);

        // Get the symbolLength

        int symbolLength = view.askSymbolLength(MIN_RANGE,
                MAX_RANGE, codeLength
        );

        // Set the code && message
        setSecretCode(symbolLength, codeLength);
        setSecretMessage(symbolLength, codeLength);
    }


    /* **********************
    * ****** START THE GAME *
    * *************************/

    /**
     * Handles the score view by creating a new GameScoreView, displaying the
     * initial score and message,
     * and entering a loop to handle user input, validation, and score
     * display until
     * the secret code is guessed.
     */
    private void handleScoreView() {
        // create a new view and cast it to the gamescore to use its methods
        view = new GameScoreView();
        GameScoreView gameScoreView = (GameScoreView) view;

        gameScoreView.displayMessage(getSecretMessage());
        gameScoreView.displayMessage("Okay, let's start a game!");

        // Start tge game loop
        while (true) {

            turns++;
            view.displayMessage("Turn " + turns + ":");

            // Get input
            String input = Helper.readString();
//            if(input.length() > this.secretCode.size()){
//
//            }

            // Validate score
            handleScoreValidation(input);
            gameScoreView.displayScoreGame(this.bulls, this.cows);
            if (this.bulls == this.secretCode.size()) {
                print("Congratulations! You guessed the secret code.");
                break;
            }
        }
    }

    /**
     * Handles the validation of the user's guess by calling the bull and cow
     * validation methods.
     *
     * @param guess The user's guess.
     */
    private void handleScoreValidation(String guess) {
        handleBullValidation(guess);
        handleCowValidation(guess);
    }

    /**
     * Handles the bull validation by creating a new BullValidator and
     * validating
     * the guess against the secret code.
     *
     * @param guess The user's guess.
     */
    private void handleBullValidation(String guess) {
        validateAble = new BullValidator();
        this.bulls = validateAble.validate(guess, this.secretCode);
    }

    /**
     * Handles the cow validation by creating a new CowValidator and
     * validating the
     * guess against the secret code.
     *
     * @param guess The user's guess.
     */
    private void handleCowValidation(String guess) {
        validateAble = new CowValidator();
        this.cows = validateAble.validate(guess, this.secretCode);
    }

    /**
     * Resets the score by setting the number of bulls and cows to zero.
     */
    private void resetScore() {
        this.cows = 0;
        this.bulls = 0;
    }

    /**
     * Sets the secret message based on the symbol length and code length.
     *
     * @param symbolLength The length of the symbols in the secret message.
     * @param codeLength   The length of the secret code.
     */
    private void setSecretMessage(int symbolLength, int codeLength) {
        this.secretMessage = codeGenerationStrategy.generate(symbolLength,
                codeLength
        );
    }

    /**
     * Sets the secret code based on the symbol length and code length.
     *
     * @param symbolLength The length of the symbols in the secret code.
     * @param codeLength   The length of the secret code.
     */
    private void setSecretCode(int symbolLength, int codeLength) {
        this.secretCode = listCodeGenerationStrategy.generate(symbolLength,
                codeLength
        );
    }

    /**
     * Returns the secret code.
     *
     * @return The secret code.
     */
    private List<Character> getSecretCode() {
        return this.secretCode;
    }

    /**
     * Returns the secret message.
     *
     * @return The secret message.
     */
    private String getSecretMessage() {
        return this.secretMessage;
    }

    /**
     * Gets the user's guess from the player.
     *
     * @return The user's guess.
     */
    public String getGuessFromPlayer() {
        return "";
    }

    /**
     * Displays the result of the game.
     */
    public void displayResult() {
        System.out.println("");
    }

    /**
     * Checks the win condition of the game.
     */
    public void checkWinCondition() {
        System.out.println("");
    }
}
