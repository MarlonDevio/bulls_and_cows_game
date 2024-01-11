package bullscows.validationStrategies;

import bullscows.interfaces.AsciiStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class NumbersOnlyStrategy implements the AsciiStrategy interface.
 * It is responsible for generating a list of ASCII values representing numbers.
 */
public class NumbersOnlyStrategy implements AsciiStrategy {

    /**
     * Constructor for NumbersOnlyStrategy.
     * Currently, it does not perform any specific operations.
     */
    public NumbersOnlyStrategy(){
    }

    /**
     * Generates a list of ASCII values corresponding to the numbers (0-9).
     * Utilizes the ASCII range defined in AsciiRanges for numbers.
     *
     * @return A List of Characters, each representing a number in the ASCII table.
     */
    @Override
    public List<Character> generateAsciiValues() {
        return IntStream.rangeClosed(AsciiRanges.ASCII_NUMBERS.getStart(), AsciiRanges.ASCII_NUMBERS.getEnd())
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
