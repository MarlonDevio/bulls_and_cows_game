package bullscows.refactored.codegeneration.codegenerationstrategies;

import bullscows.refactored.codegeneration.CodeGenerator;

import java.util.List;

/**
 * This class represents a secret message generator that implements the
 * CodeGenerationStrategy interface.
 * It generates a secret message based on the provided code generator, symbol
 * length, and code length.
 */
public class SecretMessageGenerator implements CodeGenerationStrategy<String> {
    CodeGenerator codeGenerator;

    /**
     * Constructs a SecretMessageGenerator object with the given code generator.
     *
     * @param codeGenerator the code generator used to generate the secret message
     */
    public SecretMessageGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    /**
     * Generates a secret message based on the symbol length and code length.
     *
     * @param symbolLength the length of the symbols used in the secret message
     * @param codeLength   the length of the code used in the secret message
     * @return the generated secret message
     */
    @Override
    public String generate(int symbolLength, int codeLength) {
        // Get first number & symbol
        char firstNumber = getFirstChar(codeGenerator.getNumbersList(), 0);
        char firstSymbol = getFirstChar(codeGenerator.getSymbolsList(), 0);

        // Get last number & symbol
        char lastNumber = getLastChar(codeGenerator.getNumbersList(), 9);
        char lastSymbol = getLastChar(
                codeGenerator.getFullLettersAndNumbersList(), symbolLength - 1);

        StringBuilder stringBuilder = new StringBuilder();

        //
        stringBuilder.append("The secret is prepared: ")
                // Build stars
                .append(buildAsteriskFromCode(codeLength))

                // Build pair
                .append(" ")
                .append("(")

                // Build number pair
                .append(buildPairs(firstNumber, lastNumber));

        // Check if no symbols being used, early close parentheses
        if (symbolLength <= 10)
            return stringBuilder.append(").")
                    .toString();

        // build symbol pair
        return stringBuilder.append(", ")
                // symbols
                .append(buildPairs(firstSymbol, lastSymbol))
                .append(").")
                .toString();
    }

    /**
     * Builds a string of asterisks based on the code length.
     *
     * @param codeLength the length of the code
     * @return a string of asterisks
     */
    private String buildAsteriskFromCode(int codeLength) {
        return "*".repeat(Math.max(0, codeLength));
    }

    /**
     * Builds a string representing a pair of characters.
     *
     * @param firstNum the first character
     * @param lastNum  the last character
     * @return a string representing the pair of characters
     */
    private String buildPairs(char firstNum, char lastNum) {
        return firstNum +
                "-" +
                lastNum;
    }

    /**
     * Retrieves the first character from the given character list at the specified
     * index.
     *
     * @param charList the character list
     * @param index    the index of the character to retrieve
     * @return the first character from the list at the specified index
     */
    private char getFirstChar(List<Character> charList, int index) {
        return charList.get(index);
    }

    /**
     * Retrieves the last character from the given character list at the specified
     * index.
     *
     * @param charList the character list
     * @param index    the index of the character to retrieve
     * @return the last character from the list at the specified index
     */
    private char getLastChar(List<Character> charList, int index) {
        return charList.get(index);
    }
}
