package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.AlternatingParity;

public class AlternatingParityTest {

	private static AlternatingParity alternatingParity = null;

	@BeforeClass
	public static void setup() {
		alternatingParity = new AlternatingParity();
	}
	
	@Test
	public void testCaptureIntegerPortion_01() {

		//one odd then one even
		String input = "12";
		List<String> correctAnswer = Arrays.asList("12");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureIntegerPortion_02() {

		//one even then one odd
		String input = "45";
		List<String> correctAnswer = Arrays.asList("45");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntegerPortion_1() {

		// alternating parity and some whitespace
		String input = "   1234\t\t\f\n\n";
		List<String> correctAnswer = Arrays.asList("1234");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntegerPortion_2() {

		// several decimal numbers, two that work and some other stuff
		String input = "yyy 81436709 555.111 7872 9877654.321 abracadabra, tacos, moon-beam.876.125";
		List<String> correctAnswer = Arrays.asList("81436709", "7872", "321","876","125");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntegerPortion_4() {

		// mix of decimal and integer numbers
		String input = "92\t12345   2468     911.114     72981   80085 347210 10";
		List<String> correctAnswer = Arrays.asList("92", "12345", "72981", "347210", "10");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntegerPortion_3() {

		// throw in some punctuation like in a normal sentence
		String input = "I had 33 apples and 34 oranges.  Then my mantis ate 25 fruit flies.";
		List<String> correctAnswer = Arrays.asList("34", "25");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntegerPortion_5() {

		// some tricky invalid numbers mixed in
		String input = " 4587 1 2 1 2 1 2 1 2 1 121212121 91.91. 901 .3456 12. ";
		List<String> correctAnswer = Arrays.asList("4587", "121212121", "901","3456","12");

		List<String> compositionAnswer = alternatingParity.captureIntegerPortion(input);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
}
