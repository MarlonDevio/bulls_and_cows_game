package bullscows.controller;

import bullscows.interfaces.ICodeView;
import bullscows.model.Code;
import bullscows.view.CodeView;

public class CodeValidationController {
	private ICodeView codeView;
	private Code code;

	public CodeValidationController() {
		this(new CodeView(), new Code());
	}

	public CodeValidationController(ICodeView view, Code code) {
		this.codeView = view;
		this.code = code;
	}

	public void handleUserCodeValidation() {
		int codeLength;
		while (true) {
			codeLength = codeView.askCodeLength();
			if (!(code.isValidMaxLength(codeLength))) {
				codeView.displayMessage("Too long!");
				continue;
			}
			code.setCodeLength(codeLength);
			break;
		}
	}

	public void handleUserSymbolValidation() {
		int symbolLength;
		while (true) {
			symbolLength = codeView.askSymbolLength();
			if (!(code.isValidMaxSymbols(symbolLength))) {
				codeView.displayMessage("Too many symbols!");
				continue;
			}
			code.setPossibleSymbols(symbolLength);
			break;
		}
	}

}
