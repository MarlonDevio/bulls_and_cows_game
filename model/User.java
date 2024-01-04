package bullscows.model;

public class User {
	private int bulls;
	private int cows;
	private String name;
	private String guess;


	public User(){}
	public User(String name){
		this.name = name;
	}


	public int getBulls() {
		return bulls;
	}

	private void setBulls(int bulls) {
		this.bulls = bulls;
	}

	public int getCows() {
		return cows;
	}

	private void setCows(int cows) {
		this.cows = cows;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}
	public String getGuess(){
		return this.guess;
	}

	public void setBullsAndCows(int bulls, int cows){
		this.bulls = bulls;
		this.cows = cows;
	}
}
