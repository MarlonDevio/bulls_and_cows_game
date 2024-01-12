package bullscows.refactored.coderequirementhandling;

public abstract class View {
    public abstract int getNumericValueFromUser(String message, int minRange, int maxRange);

    public abstract int getSymbolLengthFromUserInput(int minRange, int maxRange);

    public abstract int askSymbolLength(int minRange, int maxRange, int codeLength);

    public abstract void displayMessage(String message);
}
