package bullscows.displayStrategies;

import bullscows.interfaces.DisplayBehavior;

import static bullscows.helpers.Helper.print;

public class BullsAndCowsDisplayBehavior implements DisplayBehavior {

    @Override
    public void display() {
        print("No scores given!");
    }

    @Override
    public void display(String message) {
        print(message);
    }

    @Override
    public void display(int bulls, int cows) {
        print(displayScore(bulls,cows));

    }

    public String displayScore(int bullScore, int cowScore){

        String bullGrade = buildAnimalScore(bullScore, "bull");
        String cowGrade = buildAnimalScore(cowScore, "cow");

        StringBuilder builder = new StringBuilder("Grade: ");
        if(isZero(bullScore,cowScore)){
            return builder.append("None.").toString();
        }

        if(isZero(cowScore))
            return builder.append(bullGrade).toString();

        if(isZero(bullScore)){
            return builder.append(cowGrade).toString();
        }

        return builder.append(bullGrade).append(" and ").append(cowGrade).toString();
    }

    private boolean isZero(int bullScore, int cowScore){
        return isZero(bullScore) && isZero(cowScore);
    }

    private boolean isZero(int score){
        return score == 0;
    }

    private String buildAnimalScore(int score, String name) {
        return score +
                " " +
                (score > 1 ? name + "s" : name);
    }

}
