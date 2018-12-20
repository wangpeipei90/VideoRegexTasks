package test.match;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.match.ValidEmail;

public class ValidEmailTest {

	private static ValidEmail validEmail = null;

	@BeforeClass
	public static void setup() {
		validEmail = new ValidEmail();
	}

	@Test
	public void testIsValidEmail_1() {
		
		//a typical email
		String anyLine = "name@domain.com";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_2() {
		
		//weird but valid email
		String anyLine = "###/+-?^_`{|}~$$$***@weird.do";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_3() {
		
		//also weird but valid
		String anyLine = "1.2.3.4@crazy.domain.axes";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_4() {
		
		//a twitter handle - not valid
		String anyLine = "@tweetybirdHandle";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_5() {
		
		//a website - not valid
		String anyLine = "www.website.com";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_6() {
		
		//what is this?  it's just a word, of course it's not valid
		String anyLine = "oneWord";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_7() {
		
		//maybe the weirdest valid email I could think of
		String anyLine = "!@B.gone";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsValidEmail_8() {
		
		//a sentence - invalid
		String anyLine = "Look at that lightning storm - it's getting closer!";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = validEmail.isValidEmail(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

}
