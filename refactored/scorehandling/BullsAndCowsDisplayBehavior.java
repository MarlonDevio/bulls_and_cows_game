package bullscows.refactored.scorehandling;

import static bullscows.refactored.helpers.Helper.print;

/**
 * The BullsAndCowsDisplayBehavior class implements the DisplayBehavior
 * interface
 * and provides methods for displaying scores and messages related to the Bulls
 * and Cows game.
 */
public class BullsAndCowsDisplayBehavior implements DisplayBehavior {

    /**
     * Displays a default message when no scores are given.
     */
    @Override
    public void display() {
        print("No scores given!");
    }

    /**
     * Displays a custom message.
     *
     * @param message the message to be displayed
     */
    @Override
    public void display(String message) {
        print(message);
    }

    /**
     * Displays the score in the format "Grade: X bulls and Y cows".
     *
     * @param bulls the number of bulls
     * @param cows  the number of cows
     */
    @Override
    public void display(int bulls, int cows) {
        print(displayScore(bulls, cows));
    }

    /**
     * Builds and returns the score string based on the number of bulls and cows.
     *
     * @param bullScore the number of bulls
     * @param cowScore  the number of cows
     * @return the score string
     */
    private String displayScore(int bullScore, int cowScore) {

        String bullGrade = buildAnimalScore(bullScore, "bull");
        String cowGrade = buildAnimalScore(cowScore, "cow");

        StringBuilder builder = new StringBuilder("Grade: ");
        if (isZero(bullScore, cowScore)) {
            return builder.append("None.").toString();
        }

        if (isZero(cowScore))
            return builder.append(bullGrade).toString();

        if (isZero(bullScore)) {
            return builder.append(cowGrade).toString();
        }

        return builder.append(bullGrade).append(" and ").append(cowGrade).toString();
    }

    /**
     * Checks if both the bull score and cow score are zero.
     *
     * @param bullScore the number of bulls
     * @param cowScore  the number of cows
     * @return true if both scores are zero, false otherwise
     */
    private boolean isZero(int bullScore, int cowScore) {
        return isZero(bullScore) && isZero(cowScore);
    }

    /**
     * Checks if the score is zero.
     *
     * @param score the score to be checked
     * @return true if the score is zero, false otherwise
     */
    private boolean isZero(int score) {
        return score == 0;
    }

    /**
     * Builds and returns the animal score string based on the score and animal
     * name.
     *
     * @param score the score
     * @param name  the name of the animal
     * @return the animal score string
     */
    private String buildAnimalScore(int score, String name) {
        return score +
                " " +
                (score > 1 ? name + "s" : name);
    }

}
