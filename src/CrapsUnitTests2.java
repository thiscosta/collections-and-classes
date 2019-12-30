import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrapsUnitTests2 {

	Craps craps;

	@BeforeEach
	void setUp()  {
		craps = new Craps();
	}
	
	@Test
	//Task 1
	void testShoot() {
		assertTrue(craps.getDice1().getFaceValue() == 0);
		assertTrue(craps.getDice2().getFaceValue() == 0);
		craps.shoot();
		assertTrue(craps.getDice1().getFaceValue() > 0);
		assertTrue(craps.getDice2().getFaceValue() > 0);
	}
	
	@Test
	//Task 2
	void testAddUpScore() {
		craps.shoot();
		assertEquals(craps.addUpScore(), craps.getDice1().getFaceValue() +craps.getDice2().getFaceValue() );
	}
	
}




