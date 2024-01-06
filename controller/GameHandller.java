package bullscows.controller;

import bullscows.model.Code;
import bullscows.view.CodeView;

public class GameHandller {
	private CodeValidationController codeValidationController;
	private CodeView codeView;
	private Code code;

	public GameHandller(){
		this.codeView = new CodeView();
		this.code = new Code();
		this.codeValidationController = new CodeValidationController(codeView,code);
		this.codeValidationController.handleUserCodeValidation();
		this.codeValidationController.handleUserSymbolValidation();


	}

}
