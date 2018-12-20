package test.search;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.search.NoVowelsWord;

public class NoVowelsWordTest {

	private static NoVowelsWord noVowelsWord = null;

	@BeforeClass
	public static void setup() {
		noVowelsWord = new NoVowelsWord();
	}

	@Test
	public void testHasNoVowelsWord_1() {
		
		//the word 'CTMPTS' has no vowels
		String anyLine = "April and Ron are taking CTMPTS training";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = noVowelsWord.hasNoVowelsWord(anyLine);
		assertTrue(compositionAnswer==correctAnswer);
	}
	
	@Test
	public void testHasNoVowelsWord_2() {
		
		//all these words have vowels
		String anyLine = "In most sentences, all words have vowels.";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = noVowelsWord.hasNoVowelsWord(anyLine);
		assertTrue(compositionAnswer==correctAnswer);
	}
	
	@Test
	public void testHasNoVowelsWord_3() {
		
		//this sentence has many only-vowel words
		String anyLine = "Y pck p th vlt pbbl, and place it in the wtr.";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = noVowelsWord.hasNoVowelsWord(anyLine);
		assertTrue(compositionAnswer==correctAnswer);
	}
	
	@Test
	public void testHasNoVowelsWord_4() {
		
		//all non-vowels
		String anyLine = "bcdfghjklmnpqrstvwxyz";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = noVowelsWord.hasNoVowelsWord(anyLine);
		assertTrue(compositionAnswer==correctAnswer);
	}
	
	@Test
	public void testHasNoVowelsWord_5() {
		
		//all vowels
		String anyLine = "aeiou";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = noVowelsWord.hasNoVowelsWord(anyLine);
		assertTrue(compositionAnswer==correctAnswer);
	}

}
