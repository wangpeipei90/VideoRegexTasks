package test.findMany;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import compose.findMany.GoogleKeywords;

public class GoogleKeywordsTest {

	private static GoogleKeywords googleKeywords = null;

	@BeforeClass
	public static void setup() {
		googleKeywords = new GoogleKeywords();
	}

	@Test
	public void testCaptureKeywords_1() {
		
		//just the word 'what'
		String searchURL = "https://www.google.com/?gws_rd=ssl#safe=off&q=what";
		List<String> correctAnswer = Arrays.asList("what");
		
		List<String> compositionAnswer = googleKeywords.captureKeywords(searchURL);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureKeywords_2() {
		
		//giberish
		String searchURL = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#safe=off&q=+hdbxdgbhnfjvmncdnh";
		List<String> correctAnswer = Arrays.asList("+hdbxdgbhnfjvmncdnh");
		
		List<String> compositionAnswer = googleKeywords.captureKeywords(searchURL);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureKeywords_3() {
		
		//now the non-query fields are different.  I obtained this by using firefox.
		String searchURL = "https://www.google.com/?gws_rd=ssl#q=take+me+to+my+website";
		List<String> correctAnswer = Arrays.asList("take+me+to+my+website");
		
		List<String> compositionAnswer = googleKeywords.captureKeywords(searchURL);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureKeywords_4() {
		
		//now some words obtained using IE
		String searchURL = "https://www.google.com/#safe=off&q=feeling+good+on+a+wednesday";
		List<String> correctAnswer = Arrays.asList("feeling+good+on+a+wednesday");
		
		List<String> compositionAnswer = googleKeywords.captureKeywords(searchURL);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureKeywords_5() {
		
		//several random words
		String searchURL = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#safe=off&q=alias+bones+torpedo+sordid+soccer";
		List<String> correctAnswer = Arrays.asList("alias+bones+torpedo+sordid+soccer");
		
		List<String> compositionAnswer = googleKeywords.captureKeywords(searchURL);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
