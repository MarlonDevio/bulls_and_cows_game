package bullscows.view;

import bullscows.interfaces.ICodeView;

public class CodeView extends MainView implements ICodeView {

	public int askCodeLength(){
		return getIntegerInput("What is the code length?");
	}

	@Override
	public int askSymbolLength() {
		return 0;
	}

	@Override
	public void displayMessage() {
		System.ou;
	}

	public int askCodeLength(String question) {
		return getIntegerInput(question);
	}

	public int askSymbolLength(String question) {
		return getIntegerInput(question);
	}



	}
