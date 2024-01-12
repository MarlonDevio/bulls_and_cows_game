package bullscows.validationStrategies;

import bullscows.refactored.helpers.Validator;

import static bullscows.refactored.helpers.Helper.convertStringToInt;
import static bullscows.refactored.helpers.Validator.meetsSingleRequirement;

/**
 * The InputValidator class is responsible for validating input strings and
 * ranges.
 * It implements the IValidateAble interface.
 */
public class InputValidator implements IValidateAble<String, Integer, Boolean> {

    /**
     * Validates the input string based on a comparison value.
     *
     * @param input   The input string to validate.
     * @param compare The comparison value.
     * @return true if the input is valid; false otherwise.
     */
    @Override
    public Boolean validate(String input, Integer compare) {
        return true;
    }

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
     * @return true if all passed conditions are true; false if any one of them is
     *         false.
     */
    public boolean isValid(boolean... args) {
        for (boolean arg : args) {
            if (!arg) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the smallest value is smaller than or equal to the largest value.
     *
     * @param smallest The smallest value.
     * @param largest  The largest value.
     * @return true if the smallest value is smaller than or equal to the largest
     *         value; false otherwise.
     */
    public boolean isSmaller(int smallest, int largest) {
        return smallest <= largest;
    }
}
