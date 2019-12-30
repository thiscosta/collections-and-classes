import java.util.Random;

public class Dice {

    private int state;

	public void roll() {
		state =  new Random().nextInt(6) + 1;
	}

	public int getFaceValue() {
		return state;
	}

	public String toString() {
		return String.valueOf(state);
	}

}
