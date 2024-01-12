package bullscows.validationStrategies;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The CowValidator class implements the IValidateAble interface and provides
 * a method to validate a guess against a secret code by counting the number of
 * cows. A cow is a character that exists in the secret code but is not in the
 * correct position in the guess.
 *
 */
public class CowValidator implements IValidateAble<String, List<Character>,
        Integer> {

    /**
     * Validates the guess against the secret code and returns the number of
     * cows.
     *
     * @param input   the guess to be validated
     * @param compare the secret code to compare against
     * @return the number of cows in the guess
     */
    @Override
    public Integer validate(String input, List<Character> compare) {
        return IntStream.range(0, input.length())
                .filter(i -> i >= input.length() ||
                        compare.get(i) != input.charAt(i))
                .map(i -> (int) IntStream.range(0, compare.size())
                        .filter(j -> j != i &&
                                input.charAt(i) == compare.get(j))
                        .count())
                .sum();
    }

}
