package bullscows.strategies;

import bullscows.interfaces.AsciiStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class LettersStrategy implements the AsciiStrategy interface.
 * It is responsible for generating a list of ASCII values representing letters.
 */
public class LettersStrategy implements AsciiStrategy {

    /**
     * Generates a list of ASCII values corresponding to the letters (a-z, A-Z).
     * Utilizes the ASCII range defined in AsciiRanges for letters.
     *
     * @return A List of Characters, each representing a letter in the ASCII table.
     */
    @Override
    public List<Character> generateAsciiValues() {
        return IntStream.rangeClosed(AsciiRanges.ASCII_LETTERS.getStart(), AsciiRanges.ASCII_LETTERS.getEnd())
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
