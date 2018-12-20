package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.RepeatedWords;

public class RepeatedWordsTest {

	private static RepeatedWords repeatedWords = null;

	@BeforeClass
	public static void setup() {
		repeatedWords = new RepeatedWords();
	}

	@Test
	public void testCaptureSentencesWithReapeatedWords_1() {
		
		//three sentences, two have repreated words
		String textBlock = "I was very, very happy to see you.  We were partying.  So I ate way, way too many cookies.";
		List<String> correctAnswer = Arrays.asList("very", "way");
		
		List<String> compositionAnswer = repeatedWords.captureReapeatedWords(textBlock);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureSentencesWithReapeatedWords_2() {
		
		//another example
		String textBlock = "See Bob run.  Watch dog barking.  Throw a party for the special, special person.  Don't be late.  Bring a present.  Make sure to keep it it a secret.";
		List<String> correctAnswer = Arrays.asList("special", "it");
		
		List<String> compositionAnswer = repeatedWords.captureReapeatedWords(textBlock);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureSentencesWithReapeatedWords_3() {
		
		//another example, with some easy mistakes thrown in
		String textBlock = "Silent night.  Silent night.  Happy happy night.  It's to too towards torpedo tobogan, too.  Quite a quiet quitter - quite!  Sandwich specials start, starting at starting time.";
		List<String> correctAnswer = Arrays.asList("Happy");
		
		List<String> compositionAnswer = repeatedWords.captureReapeatedWords(textBlock);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureSentencesWithReapeatedWords_4() {
		
		//Sentences can also end in question marks or exclamation points!
		String textBlock = "I am going to ask some questions, questions!  What is your name, name?  Okay fine don't tell me.";
		List<String> correctAnswer = Arrays.asList("questions","name");
		
		List<String> compositionAnswer = repeatedWords.captureReapeatedWords(textBlock);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureSentencesWithReapeatedWords_5() {
		
		//these are still words, they are just weird looking
		String textBlock = "My name is R2D2, what is is your name?  I'm C3PO.";
		List<String> correctAnswer = Arrays.asList("is");
		
		List<String> compositionAnswer = repeatedWords.captureReapeatedWords(textBlock);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
