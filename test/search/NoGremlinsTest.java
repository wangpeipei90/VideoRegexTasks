package test.search;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.search.NoGremlins;

public class NoGremlinsTest {

	private static NoGremlins noGremlins = null;

	@BeforeClass
	public static void setup() {
		noGremlins = new NoGremlins();
	}

	@Test
	public void testNoGremlinsFound_1() {
		
		//some regular letters - no gremlins
		String anyLine = "abcdefghijklmnop";
		boolean correctAnswer = true;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testNoGremlinsFound_2() {
		
		//again, no gremlins
		String anyLine = "1 2 3 4 \t\n   silencio ___";
		boolean correctAnswer = true;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testNoGremlinsFound_3() {
		
		//the form feed at the beginning is a gremlin
		String anyLine = "\fabc";
		boolean correctAnswer = false;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testNoGremlinsFound_4() {
		
		//the carriage return at the end is a gremlin
		String anyLine = "123\r ";
		boolean correctAnswer = false;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testNoGremlinsFound_5() {
		
		//this backspace character is a gremlin
		String anyLine = "    \b    ";
		boolean correctAnswer = false;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

	/**
	 * expand to see hint:*****************************************************
	 * a carriage-return at the end of the input might be interpreted as a
	 * Terminator.  
	 **/
	@Test
	public void testNoGremlinsFound_6() {
		
		//this carriage return is a gremlin
		String anyLine = "123\r";
		boolean correctAnswer = false;

		boolean compositionAnswer = noGremlins.noGremlinsFound(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}

}
