package bullscows.refactored.helpers;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static bullscows.refactored.helpers.Helper.print;

/**
 * Validator class provides a set of static methods for validating different
 * types of inputs.
 * It includes methods for checking numeric and alphabetic strings, and for
 * more complex validations
 * like checking uniqueness of elements in a string or iterable based on
 * specified conditions.
 */
public class Validator {

    /*******************************************************
     ********** Basic Type Validators ***********************
     *******************************************************/

    /**
     * Checks if a string is numeric.
     *
     * @param input The string to be checked.
     * @return true if the input string is numeric; false otherwise.
     */
    public static boolean isNumeric(String input) {
        return input.matches("-?\\d+");
    }

    /**
     * Checks if a string is alphabetic.
     *
     * @param input The string to be checked.
     * @return true if the input string is alphabetic; false otherwise.
     */
    public static boolean isAlphabetic(String input) {
        return input.matches("^[a-zA-Z]+$");
    }


    /********************************************************
     ********* Advanced Validators **************************
     *******************************************************/

    /**
     * Checks if all elements in a string are unique and meet a specified
     * condition.
     *
     * @param input     The string whose elements are to be checked.
     * @param condition The condition (expressed as a Predicate) that each
     *                  character must meet.
     * @return true if all characters in the string are unique and meet the
     * condition; false otherwise.
     */
    public static boolean areAllElementsUnique(String input,
                                               Predicate<Character> condition) {
        Set<Character> uniqueElements = new HashSet<>();
        for (Character c : input.toCharArray()) {
            if (!condition.test(c)) {
                System.out.println(
                        "One or more characters don't meet the requirements");
                return false;
            }
            if (!uniqueElements.add(c)) {
                System.out.println("Not all characters are unique!");
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all elements in an iterable meet a specified condition and
     * prints a custom error message if not.
     *
     * @param <T>          The type of elements in the iterable.
     * @param elements     The iterable to be checked.
     * @param condition    The condition (expressed as a Predicate) that each
     *                    element must meet.
     * @param errorMessage The error message to be printed if a condition is
     *                     not met.
     * @return true if all elements meet the condition; false otherwise.
     */
    public static <T> boolean meetsRequirements(Iterable<T> elements,
                                                Predicate<T> condition,
                                                String errorMessage) {
        for (T element : elements) {
            if (!condition.test(element)) {
                print(errorMessage);
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all elements in an iterable are unique and prints a custom
     * error message if not.
     *
     * @param <T>          The type of elements in the iterable.
     * @param elements     The iterable whose elements are to be checked for
     *                     uniqueness.
     * @param errorMessage The error message to be printed if an element is
     *                     not unique.
     * @return true if all elements in the iterable are unique; false otherwise.
     */
    public static <T> boolean elementsAreUnique(Iterable<T> elements,
                                                String errorMessage) {
        Set<T> uniqueElements = new HashSet<>();
        for (T element : elements) {
            if (!uniqueElements.add(element)) {
                print(errorMessage);
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a single value meets a specified requirement.
     *
     * @param <T>          The type of the value.
     * @param value        The value to be checked.
     * @param condition    The condition (expressed as a Predicate) that the
     *                     value must meet.
     * @param errorMessage The error message to be printed if the condition
     *                     is not met.
     * @return true if the value meets the condition; false otherwise.
     */
    public static <T> boolean meetsSingleRequirement(T value,
                                                     Predicate<T> condition,
                                                     String errorMessage) {
        if (!condition.test(value)) {
            print(errorMessage);
            return false;
        }
        return true;
    }
    public static <T> boolean meetsSingleRequirement(T value,
                                                     Predicate<T> condition
                                                     ) {
        return condition.test(value);
    }


}

/**
 * public static <T> boolean meetsRequirements(Iterable<T> elements,
 * Predicate<T> condition,
 * String errorMessage) {
 * for (T element : elements) {
 * if (!condition.test(element)) {
 * print(errorMessage);
 * return false;
 * }
 * }
 * return true;
 * }
 * <p>
 * public static boolean meetsRequirements(String input,
 * Predicate<Character> condition,
 * String errorMessage) {
 * return meetsRequirements(toCharacterIterable(input), condition,
 * errorMessage);
 * }
 * <p>
 * public static <T> boolean elementsAreUnique(Iterable<T> elements, String
 * errorMessage) {
 * Set<T> uniqueElements = new HashSet<>();
 * for (T element : elements) {
 * if (!uniqueElements.add(element)) {
 * print(errorMessage);
 * return false;
 * }
 * }
 * return true;
 * }
 * <p>
 * public static boolean elementsAreUnique(String input, String errorMessage) {
 * return elementsAreUnique(toCharacterIterable(input), errorMessage);
 * }
 * <p>
 * <p>
 * public static boolean meetsRequirements(String input,
 * //                                            Predicate<Character> condition,
 * //                                            String errorMessage) {
 * //        for (Character c : input.toCharArray()) {
 * //            if (!condition.test(c)) {
 * //                print(errorMessage);
 * //                return false;
 * //            }
 * //        }
 * //        return true;
 * //    }
 * //
 * //    public static boolean elementsAreUnique(String input, String
 * errorMessage) {
 * //        Set<Character> uniqueElements = new HashSet<>();
 * //        for (Character c : input.toCharArray()) {
 * //            if (!uniqueElements.add(c)) {
 * //                print(errorMessage);
 * //                return false;
 * //            }
 * //        }
 * //        return true;
 * //    }
 *
 */
