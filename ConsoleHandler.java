package bullscows;

import static bullscows.helpers.Helper.*;


public class ConsoleHandler {
    InputValidator inputValidator = new InputValidator();
    public ConsoleHandler(){
    }

    public int getNumericValueFromUser(String message, int minRange, int maxRange) {
        while (true) {
            print(message);
            String input = readString();
            if(inputValidator.validateRange(input,minRange, maxRange)){
                return convertStringToInt(input);
            }
        }
    }

    public void displayHiddenCode(String hiddenCode){
        print("The hidden code is prepared: "+hiddenCode+" ");
        print(hiddenCode);
    }



    public int getNumberOfSymbolsFromUser(){
        return 0;
    }
}
