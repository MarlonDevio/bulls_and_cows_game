package bullscows;

import bullscows.interfaces.DisplayBehavior;

import static bullscows.helpers.Helper.*;


public class ConsoleHandler {
    DisplayBehavior displayBehavior;
    InputValidator inputValidator = new InputValidator();

    public ConsoleHandler() {
    }

    public void setDisplayBehavior(DisplayBehavior displayBehavior){
        this.displayBehavior = displayBehavior;
    }

    public DisplayBehavior getDisplayBehavior(){
        return this.displayBehavior;
    }
    public void displayGameMessage(){
       print("Okay, let's start a game!");
    }
    public int getNumericValueFromUser(String message, int minRange,
                                       int maxRange) {
        while (true) {
            print(message);
            String input = readString();
            if (inputValidator.validateRange(input, minRange, maxRange)) {
                return convertStringToInt(input);
            }
        }
    }

    public int getSymbolLengthFromUserInput(int minRange, int maxRange) {
        return getNumericValueFromUser(
                "Input the number of possible symbols in the code:", minRange,
                maxRange);
    }

    public int askSymBolLength(int minRange, int maxRange, int codeLength) {
        while (true) {
            int symLength = getSymbolLengthFromUserInput(minRange, maxRange);
            if (!inputValidator.isSmaller(codeLength, symLength)) {
                print("Length of the secret code cannot be higher than the " +
                        "possible symbols in the code.");
                continue;
            }
            return symLength;
        }
    }

    public void displayHiddenCode(String hiddenCode) {
        print(hiddenCode);
    }

    private boolean isOnlyNumbers(int symbolLength) {
        return symbolLength <= 10;
    }


}
