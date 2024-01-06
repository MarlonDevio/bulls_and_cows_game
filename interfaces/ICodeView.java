package bullscows.interfaces;

public interface ICodeView {
	int askCodeLength();

	int askCodeLength(String question);

	int askSymbolLength(String question);
	int askSymbolLength();

	void displayMessage();

	void displayMessage(String message);
}
