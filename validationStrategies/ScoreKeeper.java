package bullscows.validationStrategies;

import bullscows.interfaces.IValidateAble;

import java.util.ArrayList;
import java.util.List;

public class ScoreKeeper {
    private int bulls;
    private int cows;
    private IValidateAble<String, List<Character>, Integer> codeChecker;
    private ArrayList<Character> secretCode;

    public ScoreKeeper(){
    };

    public void setSecretCode(ArrayList<Character> code) {
        this.secretCode = code;
    }

    public void checkForBulls(String userInput) {
       this.codeChecker = new BullValidator();
       this.bulls = codeChecker.validate(userInput, secretCode);
    }

    public void checkForCows(String userInput){
        this.codeChecker = new CowValidator();
        this.cows = codeChecker.validate(userInput, secretCode);
    }

    public int getCows(){
        return this.cows;
    }


    public int getBulls(){
        return this.bulls;
    }
}
