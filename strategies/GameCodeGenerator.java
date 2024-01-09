package bullscows.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class GameCodeGenerator extends AbstractCodeGenerator to generate game codes.
 * It uses both numerical and alphabetical strategies to create a list of characters
 * which can be used for generating game codes.
 */
public class GameCodeGenerator extends AbstractCodeGenerator {
    private static Random random = new Random();
    private int codeLength;
    private int symbolLength;

    // ASCII range for numbers is 48 to 57 (inclusive)

    // ASCII range for a-z is 97 to 122 (inclusive)

    /**
     * Constructor for GameCodeGenerator. Initializes strategies for generating numbers and letters.
     */
    public GameCodeGenerator() {
        numbersOnlyStrategy = new NumbersOnlyStrategy();
        lettersStrategy = new LettersStrategy();
    }

    /**
     * Retrieves a list of numeric ASCII values.
     *
     * @return An ArrayList of Characters representing numeric ASCII values.
     */
    private ArrayList<Character> getNumList(){
        return (ArrayList<Character>) numbersOnlyStrategy.generateAsciiValues();
    }

    /**
     * Retrieves a list of alphabetical ASCII values.
     *
     * @return A List of Characters representing alphabetical ASCII values.
     */
    private List<Character> getCharList(){
        return lettersStrategy.generateAsciiValues();
    }

    /**
     * Generates a random list of characters based on the specified code and symbol lengths.
     * It combines numeric and alphabetical characters.
     *
     * @return A List of Characters representing the randomly generated code.
     */
    public List<Character> generateRandomNumberList() {
        List<Character> combinedList = new ArrayList<>(getNumList());
        combinedList.addAll(getCharList());
        List<Character> newList = new ArrayList<>();

        // Code to adjust the size of the list based on symbol length
        int codeSize = this.symbolLength <= 10 ? 9 : symbolLength;
        for(int i = 0; i < this.codeLength; i++){
            int randomIndex = random.nextInt(codeSize);
            newList.add(combinedList.get(randomIndex));
        }

        return newList;
    }

    /**
     * Generates a string of asterisks (*) of the same length as the code.
     *
     * @return A String of asterisks (*) matching the code length.
     */
    public String getAsteriskFromCode() {
        return "*".repeat(Math.max(0, codeLength));
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
