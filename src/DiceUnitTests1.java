import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceUnitTests1 {

	Dice dice;

	@BeforeEach
	void setUp() {
		dice = new Dice();
	}

	@Test
	//Task 1
	void testDiceValuesRange() {
		for( int i = 1; i <=10 ; i++) {
			dice.roll();
			assertTrue(dice.getFaceValue() >= 1 && dice.getFaceValue()<= 6);
		}
	}

	@Test
	//Task 1
	void testDiceAllNumbers() {

		int[] diceValues = new int[30];

		for (int i = 0; i < diceValues.length; i++) {
			dice.roll();
			diceValues[i] = dice.getFaceValue();
		}

		List<Integer> intList = new ArrayList<Integer>(diceValues.length);
		for (int i : diceValues){
			intList.add(i);
		}

		for (int i = 1; i <= 6 ; i++) {
			assertTrue(intList.contains(i));
		}
	}
	
}
