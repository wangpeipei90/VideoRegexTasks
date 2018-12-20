package test.match;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.match.SpacedWords;

public class SpacedWordsTest {

	private static SpacedWords spacedWords = null;

	@BeforeClass
	public static void setup() {
		spacedWords = new SpacedWords();
	}

	@Test
	public void testIsSpacedWords_1() {
		
		//four words - valid
		String anyLine = "siliceous question knurl whillikers";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_2() {
		
		//we do not allow commas
		String anyLine = "rambunctious, conventional, swank conversation scape cheers he";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_3() {
		
		//four words, now with some numbers - also valid
		String anyLine = "858594 394859 yes 4749";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_4() {
		
		//we do not allow hyphens
		String anyLine = "peaceful rule foot-ball disclose goodby";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_5() {
		
		//all valid one-letter words
		String anyLine = "a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_6() {
		
		//whitespace at the ends - valid!
		String anyLine = "    siliceous     question     knurl    whillikers    ";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_7() {
		
		//tab-whitespace at the end, also valid
		String anyLine = "\tsiliceous\tquestion\tknurl\twhillikers\t";		
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_8() {
		
		//no words - invalid
		String anyLine = "      ";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_9() {
		
		//no whitespace - invalid
		String anyLine = "DUD";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_10() {
		
		//number-word and then a space: valid
		String anyLine = "999 ";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsSpacedWords_11() {
		
		//tab and then a letter-word: valid
		String anyLine = "\ta";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = spacedWords.isSpacedWords(anyLine);
		assertTrue(compositionAnswer == correctAnswer);
	}
}
