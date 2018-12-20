package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.VerbPortion;

public class VerbPortionTest {

	private static VerbPortion verbPortion = null;

	@BeforeClass
	public static void setup() {
		verbPortion = new VerbPortion();
	}

	@Test
	public void testFindsVerbs1() {
		
		// a random sentence from a public domain Japanese ghost story:
		// http://web.archive.org/web/20050207034920/http://www.eldritchpress.org/lh/diplo.html
		String ghostStory1 = "It was only my very great stupidity which caused the fault. Having been born stupid, by reason of my karma, I could not always help making mistakes. But to kill a man for being stupid is wrong--and that wrong will be repaid. So surely as you kill me, so surely shall I be avenged;--out of the resentment that you provoke will come the vengeance; and evil will be rendered for evil.";
		List<String> verbsInGhostStory1 = Arrays.asList("Hav", "mak", "be");

		List<String> verbsCapturedFromGhostStory1 = verbPortion.captureVerbs(ghostStory1);
		assertThat(verbsCapturedFromGhostStory1, equalTo(verbsInGhostStory1));
	}

	@Test
	public void testFindsVerbs2() {
		
		// a large list of 'ing'-words
		String allVerbs = "eating drinking seeing being looking creating destroying searching knowing parting swimming running kicking peeking writing programming composing finding";
		List<String> prefixes = Arrays.asList("eat", "drink", "see", "be", "look", "creat", "destroy", "search", "know", "part", "swimm", "runn", "kick", "peek", "writ", "programm", "compos", "find");

		List<String> prefixesFromAllVerbs = verbPortion.captureVerbs(allVerbs);
		assertThat(prefixesFromAllVerbs, equalTo(prefixes));
	}

	@Test
	public void testTrickyVerbs() {
		
		// don't capture "S" and "c"
		String trickyWords = "Singing, cringing";
		List<String> verbsFromTrickyWords = Arrays.asList("Sing", "cring");

		List<String> verbsCaptured = verbPortion.captureVerbs(trickyWords);
		assertThat(verbsCaptured, equalTo(verbsFromTrickyWords));
	}

	@Test
	public void fingerTest() {
		
		// don't capture "f"
		String trickyWords = " finger ";
		List<String> verbsFromTrickyWords = Arrays.asList();

		List<String> verbsCaptured = verbPortion.captureVerbs(trickyWords);
		assertThat(verbsCaptured, equalTo(verbsFromTrickyWords));
	}

	@Test
	public void testNoIngWordsFound() {
		
		// don't capture anything - there is no 'ing' here!
		String noIngWords = "Vegatables";
		List<String> nothing = Arrays.asList();

		List<String> verbsCaptured = verbPortion.captureVerbs(noIngWords);
		assertThat(verbsCaptured, equalTo(nothing));
	}

}
