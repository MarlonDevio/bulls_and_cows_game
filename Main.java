package bullscows;


import bullscows.refactored.TheGame;
import bullscows.refactored.codegeneration.CodeGenerator;
import bullscows.refactored.codegeneration.codegenerationstrategies.SecretMessageGenerator;
import bullscows.refactored.coderequirementhandling.CodeView;

public class Main {
	public static void main(String[] args) {
		CodeGenerator codeGenerator = new CodeGenerator();
		SecretMessageGenerator secretMessageGenerator = new SecretMessageGenerator(codeGenerator);
		CodeView view = new CodeView();
		TheGame theGame = new TheGame(codeGenerator, secretMessageGenerator, view);
	}
}
