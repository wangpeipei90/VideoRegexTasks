package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.PossessedPossessions;

public class PossessedPossessionsTest {

	private static PossessedPossessions possessedPossessions = null;

	@BeforeClass
	public static void setup() {
		possessedPossessions = new PossessedPossessions();
	}

	@Test
	public void testCapturePossessions_1() {
		
		//a sentence with two possessives
		String anyText = "The red tree's leaves fell into the man's basket.";
		List<String> correctAnswer = Arrays.asList("leaves", "basket");
		
		List<String> compositionAnswer = possessedPossessions.capturePossessions(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCapturePossessions_2() {
		
		//possessives with a few light twists - you need to stop capturing on non-word characters like hyphen, dash and period.
		String anyText = "Amy's diamond.  Roy's loaf of bread.  Your paper's publisher- ACM.";
		List<String> correctAnswer = Arrays.asList("diamond", "loaf","publisher");
		
		List<String> compositionAnswer = possessedPossessions.capturePossessions(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCapturePossessions_3() {
		
		//Here are some exceptions - don't capture after it's or A's, B's, C's, etc. 
		String anyText = "Charlie's horn was stolen.  It's probably not going to be returned.  The theif gets A's for originality, but B's for their mother's tears.";
		List<String> correctAnswer = Arrays.asList("horn", "probably","tears");
		
		List<String> compositionAnswer = possessedPossessions.capturePossessions(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCapturePossessions_4() {
		
		//this should not capture anything - no possessives here
		String anyText = "passing clouds hold onto shadows.  melting ice leaves nowhere to go.";
		List<String> correctAnswer = Arrays.asList();
		
		List<String> compositionAnswer = possessedPossessions.capturePossessions(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
