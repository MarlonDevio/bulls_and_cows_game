package bullscows.validationStrategies;

/**
 * This interface represents a generic validation strategy.
 * It provides a method to validate an input of type T against a compare value
 * of type C,
 * and returns a result of type R.
 *
 * @param <T> the type of the input to be validated
 * @param <C> the type of the compare value
 * @param <R> the type of the validation result
 */
public interface IValidateAble<T, C, R> {
    /**
     * Validates the input against the compare value.
     *
     * @param input   the input value to be validated
     * @param compare the compare value to be compared against the input
     * @return the validation result
     */
    R validate(T input, C compare);
}
