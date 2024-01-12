package bullscows.validationStrategies;

import java.util.List;

/**
 * The BullValidator class implements the IValidateAble interface to validate
 * the number of bulls in a guess.
 * Bulls are the correct digits in the correct positions.
 */
public class BullValidator implements IValidateAble<String, List<Character>, Integer> {

    /**
     * Validates the number of bulls in a guess by comparing each character in the
     * guess with the corresponding character in the target.
     *
     * @param toValidate the guess to be validated
     * @param toCompare  the target to compare the guess against
     * @return the number of bulls in the guess
     */
    @Override
    public Integer validate(String toValidate, List<Character> toCompare) {
        int count = 0;
        for (int i = 0; i < toValidate.length(); i++) {
            count += toValidate.charAt(i) == toCompare.get(i) ? 1 : 0;
        }
        return count;
    }
}
