package bullscows.model;

public class Code {
	private final int MAX_LENGTH = 36;
	private final int MAX_DIFFERENT_SYMBOLS = 36;
	String generatedCode;
	private int codeLength;
	private int possibleSymbols;

	public boolean isValidMaxLength(int length) {
		return length <= MAX_LENGTH;
	}

	public boolean isValidMaxSymbols(int numSymbols) {
		return numSymbols <= MAX_DIFFERENT_SYMBOLS;
	}

	public void setCodeLength(int codeLength) {
		this.codeLength = isValidMaxLength(codeLength) ? codeLength : MAX_LENGTH;
	}

	public void setPossibleSymbols(int numSymbols) {
		this.possibleSymbols = isValidMaxSymbols(numSymbols) ? numSymbols : MAX_DIFFERENT_SYMBOLS;
	}

	public void setGeneratedCode(String generatedCode){
		this.generatedCode = generatedCode;
	}

	public int getCodeLength(){
		return this.codeLength;
	}

	public int getPossibleSymbols(){
		return this.possibleSymbols;
	}
}
