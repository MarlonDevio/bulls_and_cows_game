package bullscows.model;

import bullscows.helpers.Validator;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * The CodeGenerator class is responsible for generating a unique code of random digits.
 * It uses a pseudo-random number generator to ensure the uniqueness of each digit in the code.
 */
public class CodeGenerator {
	private String code;
	private static final Random random = new Random();
	private static final int RANDOM_SYMBOL_START_ASCII = 96;

	/**
	 * Converts a set of unique characters into a string.
	 * This method is used to convert the unique set of generated digits into the final code string.
	 *
	 * @param uniqueSetOfNumbers The set of unique characters representing the digits of the code.
	 * @return A string representation of the set, which is the generated code.
	 */
	private String convertUniqueSetToString(Set<Character> uniqueSetOfNumbers){
		StringBuilder uniqueCode = new StringBuilder();
		uniqueSetOfNumbers.forEach(number -> uniqueCode.append(Character.getNumericValue(number)));
		return uniqueCode.toString();
	}

	private int getRangeOfASCIISymbols(int uniqueSymbols){
		return RANDOM_SYMBOL_START_ASCII + (uniqueSymbols-10);
	}




	/**
	 * Generates a unique code of a specified length. The code is composed of pseudo-random unique digits.
	 * If the first digit is '0', it is removed and replaced to ensure the code does not start with a zero.
	 *
	 * @param codeLength The length of the code to be generated.
	 * @return A unique code as a String.
	 */
	private String generateCode(int codeLength) {
		Set<Character> uniqueDigits = new LinkedHashSet<>();
		while (uniqueDigits.size() < codeLength) {
			int digit = random.nextInt(10); // Generate a digit between 0 and 9
			char character = (char) ('0' + digit);
			uniqueDigits.add(character);

		}
		return convertUniqueSetToString(uniqueDigits);
	}

	/**
	 * Sets the code for the current game by generating a new unique code of a specified length.
	 *
	 * @param codeLength The length of the code to be set for the current game.
	 */
	public void setCode(int codeLength){
		this.code = generateCode(codeLength);
	}

	/**
	 * Retrieves the currently set code.
	 *
	 * @return The currently set unique code.
	 */
	public String getCode(){
		return this.code;
	}
}
