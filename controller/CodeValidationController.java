package bullscows.controller;

import bullscows.interfaces.ICodeView;
import bullscows.model.Code;
import bullscows.view.CodeView;

public class CodeValidationController {
	private ICodeView codeView;
	private Code code;

	public CodeValidationController(){
		this(new CodeView(), new Code());
	}

	public CodeValidationController(ICodeView view, Code code) {
		this.codeView = view;
		this.code = code;
	}

	public void handleUserCodeValidation() {
		int codeLength = codeView.askCodeLength();
		if(!(code.isValidMaxLength(codeLength))) {
			handleUserCodeValidation();
		}

		code.setCodeLength(codeLength);
	}


}
