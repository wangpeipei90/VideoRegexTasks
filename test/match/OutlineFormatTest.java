package test.match;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.match.OutlineFormat;

public class OutlineFormatTest {

	private static OutlineFormat outlineFormat = null;

	@BeforeClass
	public static void setup() {
		outlineFormat = new OutlineFormat();
	}

	@Test
	public void testIsOutlineFormat_1() {
		
		//looks valid, but lacks one or more space after the period
		String anyLine = "\t\t\tm.eow";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_2() {
		
		//outline starting with one or more digits
		String anyLine = "       123. For this point there will be much rejoicing, while playing cones of dunshire";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_3() {
		
		//outline starting with multiple 'i' characters, after some strange whitespace
		String anyLine = "\f\f\f       iiiiiiii. is octocat a strange mascot?";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_4() {
		
		//no whitespace
		String anyLine = "A. Point A";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_5() {
		
		//not valid
		String anyLine = ". Point B";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_6() {
		
		//simple, valid outline-format
		String anyLine = "c. point C";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_7() {
		
		//too many capitol letters
		String anyLine = "XX. Uh-oh, that's one too many capitol letters.";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_8() {
		
		//we are not accepting roman numerals, or the regex would be a little harder
		String anyLine = "           IV. remember we are not doing roman numerals - they are a little harder";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_9() {
		
		//not valid
		String anyLine = "this is not an outline!";
		boolean correctAnswer = false;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
	
	@Test
	public void testIsOutlineFormat_10() {
		
		//simple, valid outline-format with some tabs
		String anyLine = "\t\t\td. point D";
		boolean correctAnswer = true;
		
		boolean compositionAnswer = outlineFormat.isOutlineFormat(anyLine);		
		assertTrue(compositionAnswer == correctAnswer);
	}
}
