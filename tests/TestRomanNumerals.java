import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	RomanNumerals romanNumerals = new RomanNumerals();
	@Test
	public void testCheckRomanNumerals_null() {		
		assertNotNull(romanNumerals);
	}

	@Test
	public void testRomanNumeral_I_1(){
		int result = romanNumerals.convertToInteger("I");
		assertEquals(1, result);
	}
	
	@Test
	public void testRomanNumeral_V_5(){
		int result = romanNumerals.convertToInteger("V");
		assertEquals(5, result);
	}
	
	@Test
	public void testRomanNumeral_X_10(){
		int result = romanNumerals.convertToInteger("X");
		assertEquals(10, result);
	}
	
	@Test
	public void testRomanNumeral_L_50(){
		int result = romanNumerals.convertToInteger("L");
		assertEquals(50, result);
	}
	
	@Test
	public void testRomanNumeral_C_100(){
		assertRomanNumerals(100, "C");
	}
	
	@Test
	public void testRomanNumeral_D_500(){
		assertRomanNumerals(500, "D");
	}
	
	public void assertRomanNumerals(int expectedOutput, String input){
		int result = romanNumerals.convertToInteger(input);
		assertEquals(expectedOutput, result);
	}
}
