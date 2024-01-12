package bullscows.refactored.coderequirementhandling;

import bullscows.validationStrategies.InputValidator;

import static bullscows.refactored.helpers.Helper.*;
import static bullscows.refactored.helpers.Helper.print;

/**
 * The CodeView class represents a view for interacting with the user in the
 * Bulls and Cows game.
 * It extends the View class and provides methods for getting numeric values and
 * symbol lengths from the user,
 * asking for symbol length, and displaying messages.
 */
public class CodeView extends View {
    private final InputValidator inputValidator = new InputValidator();

    /**
     * Gets a numeric value from the user within a specified range.
     *
     * @param message  the message to display to the user
     * @param minRange the minimum value allowed
     * @param maxRange the maximum value allowed
     * @return the numeric value entered by the user
     */
    @Override
    public int getNumericValueFromUser(String message, int minRange, int maxRange) {
        while (true) {
            print(message);
            String input = readString();
            if (inputValidator.validateRange(input, minRange, maxRange)) {
                return convertStringToInt(input);
            }
        }
    }

    /**
     * Gets the symbol length from the user input.
     *
     * @param minRange the minimum symbol length allowed
     * @param maxRange the maximum symbol length allowed
     * @return the symbol length entered by the user
     */
    @Override
    public int getSymbolLengthFromUserInput(int minRange, int maxRange) {
        return getNumericValueFromUser(
                "Input the number of possible symbols in the code:", minRange,
                maxRange);
    }

    /**
     * Asks for the symbol length from the user, ensuring it is smaller than the
     * code length.
     *
     * @param minRange   the minimum symbol length allowed
     * @param maxRange   the maximum symbol length allowed
     * @param codeLength the length of the secret code
     * @return the symbol length entered by the user
     */
    @Override
    public int askSymbolLength(int minRange, int maxRange, int codeLength) {
        while (true) {
            int symLength = getSymbolLengthFromUserInput(minRange, maxRange);
            if (inputValidator.isSmaller(codeLength, symLength)) {
                return symLength;
            }
            print("Length of the secret code cannot be higher than the " +
                    "possible symbols in the code.");
        }
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to display
     */
    @Override
    public void displayMessage(String message) {
        print(message);
    }
}
