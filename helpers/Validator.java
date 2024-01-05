package bullscows.helpers;

import bullscows.model.Code;
import bullscows.view.MainView;

public class Validator {
	Code code;
	MainView view;

	public static boolean isEqual(char c, char c1) {
		return c == c1;
	}

	public static boolean isHigherThan10(int number){
		return number > 10;
	}

}
