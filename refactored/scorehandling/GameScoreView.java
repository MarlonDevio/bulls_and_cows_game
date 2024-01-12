package bullscows.refactored.scorehandling;

import bullscows.refactored.coderequirementhandling.View;

import static bullscows.refactored.helpers.Helper.print;

/**
 * The GameScoreView class represents a view for displaying the score of a Bulls
 * and Cows game.
 * It extends the View class and provides methods for displaying the score and
 * getting user input.
 */
public class GameScoreView extends View {

    DisplayBehavior displayBehavior;

    /**
     * Constructs a GameScoreView object with no display behavior.
     */
    public GameScoreView() {
    };

    /**
     * Constructs a GameScoreView object with the specified display behavior.
     *
     * @param displayBehavior the display behavior to be used for displaying the
     *                        score
     */
    public GameScoreView(DisplayBehavior displayBehavior) {
        this.displayBehavior = displayBehavior;
    }

    /**
     * Displays the score of the Bulls and Cows game.
     *
     * @param bulls the number of bulls in the guess
     * @param cows  the number of cows in the guess
     */
    public void displayScoreGame(int bulls, int cows) {
        displayBehavior = new BullsAndCowsDisplayBehavior();
        displayBehavior.display(bulls, cows);
    }

    /**
     * Gets a numeric value from the user within the specified range.
     *
     * @param message  the message to be displayed to the user
     * @param minRange the minimum value of the range
     * @param maxRange the maximum value of the range
     * @return the numeric value entered by the user
     */
    @Override
    public int getNumericValueFromUser(String message, int minRange,
            int maxRange) {
        return 0;
    }

    /**
     * Gets the length of a symbol from the user input within the specified range.
     *
     * @param minRange the minimum value of the range
     * @param maxRange the maximum value of the range
     * @return the length of the symbol entered by the user
     */
    @Override
    public int getSymbolLengthFromUserInput(int minRange, int maxRange) {
        return 0;
    }

    /**
     * Asks the user for the length of the symbol within the specified range.
     *
     * @param minRange   the minimum value of the range
     * @param maxRange   the maximum value of the range
     * @param codeLength the length of the code
     * @return the length of the symbol entered by the user
     */
    @Override
    public int askSymbolLength(int minRange, int maxRange, int codeLength) {
        return 0;
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to be displayed
     */
    @Override
    public void displayMessage(String message) {
        print(message);
    }
}
