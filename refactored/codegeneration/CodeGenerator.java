package bullscows.refactored.codegeneration;

import bullscows.refactored.codegeneration.codegenerationstrategies.AsciiStrategy;
import bullscows.refactored.codegeneration.codegenerationstrategies.CodeGenerationStrategy;
import bullscows.refactored.codegeneration.codegenerationstrategies.LettersStrategy;
import bullscows.refactored.codegeneration.codegenerationstrategies.NumbersOnlyStrategy;

import java.util.*;

/**
 * The CodeGenerator class is responsible for generating unique codes based on
 * symbol length and code length.
 * It implements the CodeGenerationStrategy interface.
 */
public class CodeGenerator implements CodeGenerationStrategy<List<Character>> {
    AsciiStrategy asciiStrategy;
    private Random random = new Random();

    /**
     * Generates a unique code based on the given symbol length and code length.
     *
     * @param symbolLength the length of the symbol list
     * @param codeLength   the length of the generated code
     * @return a list of unique characters representing the generated code
     */
    public List<Character> generate(int symbolLength, int codeLength) {
        Set<Character> uniqueCharacters = new LinkedHashSet<>();
        int codeSize = Math.max(symbolLength, 10);

        while (uniqueCharacters.size() < codeLength) {
            int randomIndex = random.nextInt(codeSize);
            uniqueCharacters.add(getFullLettersAndNumbersList().get(randomIndex));
        }
        return uniqueCharacters.stream().toList();
    }

    /**
     * Retrieves the complete list of letters and numbers from 0 to z.
     *
     * @return a list of characters representing the complete list of letters and
     *         numbers
     */
    public List<Character> getFullLettersAndNumbersList() {
        ArrayList<Character> fullList = new ArrayList<>(getNumbersList());
        fullList.addAll(getSymbolsList());
        return fullList;
    }

    /**
     * Retrieves a list of numbers from 0 to 9.
     *
     * @return a list of characters representing the numbers from 0 to 9
     */
    public List<Character> getNumbersList() {
        asciiStrategy = new NumbersOnlyStrategy();
        return asciiStrategy.generateAsciiValues();
    }

    /**
     * Retrieves a list of letters from a to z.
     *
     * @return a list of characters representing the letters from a to z
     */
    public List<Character> getSymbolsList() {
        asciiStrategy = new LettersStrategy();
        return asciiStrategy.generateAsciiValues();
    }
}
