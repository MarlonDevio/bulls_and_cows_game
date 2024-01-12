package bullscows.refactored.codegeneration.codegenerationstrategies;

import java.util.List;

/**
 * The AsciiStrategy interface represents a strategy for generating ASCII
 * values.
 * Implementing classes should provide a list of characters representing ASCII
 * values.
 */
public interface AsciiStrategy {
    /**
     * Generates a list of characters representing ASCII values.
     *
     * @return a list of characters representing ASCII values
     */
    List<Character> generateAsciiValues();
}
