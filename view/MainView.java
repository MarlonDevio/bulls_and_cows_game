package bullscows.view;

import bullscows.helpers.CollectInput;


public abstract class MainView {

	public int getIntegerInput(){
		return CollectInput.getIntInput();
	}

	public int getIntegerInput(String question){
		return CollectInput.getIntInput(question);
	}

	public String getStringInput(String question){
		return CollectInput.getStringInput(question);
	}

	public String getStringInput(){
		return CollectInput.getStringInput();
	}



}
