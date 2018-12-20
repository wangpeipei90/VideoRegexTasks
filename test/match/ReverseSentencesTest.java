package test.match;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.match.ReverseSentences;

public class ReverseSentencesTest {

	private static ReverseSentences reverseSentences = null;

	@BeforeClass
	public static void setup() {
		reverseSentences = new ReverseSentences();
	}

	@Test
	public void testIsReversedSentences_1() {
		
		//one valid sentence
		String line = ".stcejbo dlohesuoh modnar fo hcnub a evah osla I tub ,suoicerp gib evah I";
		boolean correctAnswer = true;

		boolean compositionAnswer = reverseSentences.isReversedSentences(line);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testIsReversedSentences_2() {
		
		//no capitol letter
		String line = ".ecnetnes ton ,esarhp esrever";
		boolean correctAnswer = false;

		boolean compositionAnswer = reverseSentences.isReversedSentences(line);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testIsReversedSentences_3() {
		
		//no period
		String line = "ecnetnes ton ,esarhp esreveR";
		boolean correctAnswer = false;

		boolean compositionAnswer = reverseSentences.isReversedSentences(line);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testIsReversedSentences_4() {
		
		//three sentences
		String line = ".si ti tahw ksa ot derit oot ma I  .gnihtemos gnikam si ehS  .sriats eht no gnittis ecilA ees I";
		boolean correctAnswer = true;

		boolean compositionAnswer = reverseSentences.isReversedSentences(line);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testIsReversedSentences_5() {
		
		//two sentences, showing that we don't care about the finer details like comma placement
		String line = ".for this exercise, it is not important to make sure that the words are reversed or valiD   .they just have to follow the ruleS";
		boolean correctAnswer = true;

		boolean compositionAnswer = reverseSentences.isReversedSentences(line);
		assertTrue(compositionAnswer == correctAnswer);
	}

}
