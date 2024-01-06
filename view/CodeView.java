package bullscows.view;

import bullscows.interfaces.ICodeView;

public class CodeView extends MainView implements ICodeView {

	public int askCodeLength(){
		return askCodeLength("What is the code length?");
	}

	@Override
	public int askSymbolLength() {
		 return askSymbolLength("What's the length of the symbols");
	}

	@Override
	public void displayMessage() {
		displayMessage("");
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	public int askCodeLength(String question) {
		return getIntegerInput(question);
	}

	public int askSymbolLength(String question) {
		return getIntegerInput(question);
	}

public void he(){
	System.out.println("he");
}

	}
