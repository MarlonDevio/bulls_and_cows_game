package bullscows.validationStrategies;

import bullscows.interfaces.IValidateAble;

import java.util.List;
import java.util.stream.IntStream;

public class CowValidator implements IValidateAble<String,
        List<Character>, Integer> {
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
