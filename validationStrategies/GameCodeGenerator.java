package bullscows.validationStrategies;

import java.util.*;

/**
 * Class GameCodeGenerator extends AbstractCodeGenerator to generate game codes.
 * It uses both numerical and alphabetical strategies to create a list of
 * characters
 * which can be used for generating game codes.
 */
public class GameCodeGenerator extends AbstractCodeGenerator {
    private static final Random random = new Random();
    private int codeLength;
    private int symbolLength;

    // ASCII range for numbers is 48 to 57 (inclusive)

    // ASCII range for a-z is 97 to 122 (inclusive)

    /**
     * Constructor for GameCodeGenerator. Initializes strategies for
     * generating numbers and letters.
     */
    public GameCodeGenerator() {
        numbersOnlyStrategy = new NumbersOnlyStrategy();
        lettersStrategy = new LettersStrategy();

    }

    /*  **************************
     * Getters to get ASCII LISTS
     *****************************/

    /**
     * Retrieves a list of numeric ASCII values.
     *
     * @return An ArrayList of Characters representing numeric ASCII values.
     */
    private ArrayList<Character> getNumList() {
        return (ArrayList<Character>) numbersOnlyStrategy.generateAsciiValues();
    }

    /**
     * Retrieves a list of alphabetical ASCII values.
     *
     * @return A List of Characters representing alphabetical ASCII values.
     */
    public List<Character> getCharList() {
        return lettersStrategy.generateAsciiValues();
    }

    public List<Character> getCombinedList() {
        List<Character> combinedList = new ArrayList<>(getNumList());
        combinedList.addAll(getCharList());
        return combinedList;
    }

    /*  **************************
     * RANDOM GENERATIONS
     *****************************/

    /**
     * Generates a random list of characters based on the specified code and
     * symbol lengths.
     * It combines numeric and alphabetical characters.
     *
     * @return A List of Characters representing the randomly generated code.
     */
    public List<Character> generateRandomNumberList() {
        Set<Character> uniqueCharacters = new LinkedHashSet<>();
        // Code to adjust the size of the list based on symbol length
        int codeSize = Math.max(this.symbolLength, 10);

//        for (int i = 0; i < this.codeLength; i++) {
        while(uniqueCharacters.size() < this.codeLength){
            int randomIndex = random.nextInt(codeSize);
            uniqueCharacters.add(getCombinedList().get(randomIndex));
        }
        return new ArrayList<>(uniqueCharacters);
    }


    /*  **************************
     * SECRET MESSAGE BUILDING
     *****************************/
    public String secretMessageBuilder() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(buildSecretPrepared())
                .append(buildAsteriskFromCode())
                .append(" ")
                .append("(")
                .append(buildNumbersUsed());

        if (this.symbolLength <= 10)
            return stringBuilder.append(").")
                    .toString();

        return stringBuilder.append(", ")
                .append(buildLettersUsed())
                .append(").")
                .toString();
    }

    private String buildSecretPrepared() {
        return "The secret is prepared: ";
    }

    private String buildAsteriskFromCode() {
        return "*".repeat(Math.max(0, codeLength));
    }

    private String buildLettersUsed() {

        return determineFirstLetterSymbolUsed() + "-" +
                determineLastSymbolUsed();

    }

    private String buildNumbersUsed() {

        return determineFirstNumberUsed() +
                "-" +
                determineLastNumberUsed();
    }


    /*  **************************
     * DETERMINING THE FIRST LETTERS BEING USED
     *****************************/
    private char determineLastSymbolUsed() {

        return getCombinedList().get(symbolLength-1);
    }

    private char determineFirstLetterSymbolUsed() {
        return getCharList().get(0);
    }

    private char determineFirstNumberUsed() {
        return getNumList().get(0);
    }

    private char determineLastNumberUsed() {
        return getNumList().get(9);
    }

    /**
     * Sets the length of the symbol set used to generate the game code.
     *
     * @param symbolLength The length of the symbol set.
     */
    public void setSymbolLength(int symbolLength) {
        this.symbolLength = symbolLength;
    }

    /**
     * Sets the length of the game code to be generated.
     *
     * @param codeLength The length of the game code.
     */
    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }
}
