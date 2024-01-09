package bullscows;

import bullscows.helpers.Validator;

import static bullscows.helpers.Helper.convertStringToInt;
import static bullscows.helpers.Helper.print;
import static bullscows.helpers.Validator.isNumeric;
import static bullscows.helpers.Validator.meetsSingleRequirement;

public class InputValidator {
    public boolean validateCodeLength(String input) {
        return meetsSingleRequirement(input, Validator::isNumeric,
                "No characters, only digits between 1 - 36 are " +
                        "allowed.")
                &&
                meetsSingleRequirement(convertStringToInt(input),
                        val -> val <= 36 && val >= 1,
                        convertStringToInt(input) > 36
                        ? "The maximum length of the code can only be 36."
                        : "Can't be lower than 1");
    }

    public boolean validateRange(String input, int minRange, int maxRange) {
        return meetsSingleRequirement(input, Validator::isNumeric,
                "No characters, only digits between " + minRange + "/" +
                        maxRange + " are " +
                        "allowed.")
                && meetsSingleRequirement(convertStringToInt(input),
                val -> val <= maxRange && val >= minRange,
                convertStringToInt(input) < minRange
                ? "Can't be lower than " + minRange + "."
                : "Can't be higher than " + maxRange + ".");
    }

    public boolean isValid(boolean... args) {
        for (boolean arg : args) {
            if (!arg) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidCodeLength(int length) {
        if (length > 36) {
            print("Length of the code can't be higher than 36.");
            return false;
        }
        if (length < 1) {
            print("Length of the code can't be lower than 1");
            return false;
        }
        return true;
    }

    public boolean isValidCodeLength(String length) {
        return isValidCodeLength(convertStringToInt(length));
    }

    public boolean inputLengthIsNumber(String input) {
        return isNumeric(input);
    }


}
