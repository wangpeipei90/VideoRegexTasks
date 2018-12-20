package test.match;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.match.ValidPhoneNumber;

public class ValidPhoneNumberTest {

	private static ValidPhoneNumber validPhoneNumber = null;

	@BeforeClass
	public static void setup() {
		validPhoneNumber = new ValidPhoneNumber();
	}

	@Test
	public void testIsValidPhoneNumber_1() {
		
		//an email - invalid
		String anyLine = "name@domain.com";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_2() {
		
		//regular dash-separated phone number
		String anyLine = "919-000-1224";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_3() {
		
		//has dashes and the parenthesis - okay
		String anyLine = "(919)-000-1224";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_4() {
		
		//space-separated is also valid
		String anyLine = "(919) 000 1224";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_5() {
		
		//space-separated and no parenthesis is okay
		String anyLine = "919 000 1224";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_6() {
		
		//four number area code in parenthesis is invalid
		String anyLine = "(9197)-000-1224";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_7() {
		
		//too many digits
		String anyLine = "(919) 00099 1224";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_8() {
		
		//too many digits
		String anyLine = "919 000 122404";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	@Test
	public void testIsValidPhoneNumber_9() {
		
		//has a letter
		String anyLine = "919-0A0-1224";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_10() {
		
		//no spaces, dashes or parenthesis - just 10 digits: valid
		String anyLine = "1234567890";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_11() {
		
		//you can space just the area code
		String anyLine = "012 3456789";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_12() {
		
		//you can space just the last four, although it looks weird to me
		String anyLine = "123456 7890";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidPhoneNumber_13() {
		
		//no spaces, dashes or parenthesis - just 11 digits: invalid
		String anyLine = "12345678901";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validPhoneNumber.isValidPhoneNumber(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
}
