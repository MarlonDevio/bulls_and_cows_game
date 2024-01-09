package bullscows;

import bullscows.helpers.Validator;

import static bullscows.helpers.Helper.convertStringToInt;
import static bullscows.helpers.Validator.meetsSingleRequirement;

public class InputValidator {
    /**
     * Validates if the given input string is within a specified range.
     *
     * @param input    The input string to validate.
     * @param minRange The minimum range value.
     * @param maxRange The maximum range value.
     * @return true if the input is within the specified range; false otherwise.
     */
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
    /**
     * Validates if all passed boolean conditions are true.
     *
     * @param args A varargs parameter representing boolean conditions.
     * @return true if all passed conditions are true; false if any one of them is false.
     */
    public boolean isValid(boolean... args) {
        for (boolean arg : args) {
            if (!arg) {
                return false;
            }
        }
        return true;
    }
}
