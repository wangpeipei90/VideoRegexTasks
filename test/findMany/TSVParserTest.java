package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.TSVParser;

public class TSVParserTest {

	private static TSVParser tsvParser = null;

	@BeforeClass
	public static void setup() {
		tsvParser = new TSVParser();
	}

	@Test
	public void testCaptureFirstAndThirdFields_1() {

		// three rows of a three column tsv file. You must capture the first and
		// third entries of each row.
		String TSVContent = "El Segundo\twww.aerospace.org/\t600K\nAmes\twww.ameslab.gov\t75K\nArgonne\twww.anl.gov\t60K";
		List<String> correctAnswer = Arrays.asList("El Segundo", "600K",
				"Ames", "75K", "Argonne", "60K");

		List<String> compositionAnswer = tsvParser
				.captureFirstAndThirdFields(TSVContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureFirstAndThirdFields_2() {

		// now each row has 5 columns, you still capture the first and third
		String TSVContent = "1\t2\t3\t4\t5\n6\t7\t8\t9\t10\n";
		List<String> correctAnswer = Arrays.asList("1", "3",
				"6", "8");

		List<String> compositionAnswer = tsvParser
				.captureFirstAndThirdFields(TSVContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureFirstAndThirdFields_3() {

		// now each row has 2 columns - don't capture anything
		String TSVContent = "1\t2\n3\t4\n5\t6\n7\t8\n9\t10\n";
		List<String> correctAnswer = Arrays.asList();

		List<String> compositionAnswer = tsvParser
				.captureFirstAndThirdFields(TSVContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureFirstAndThirdFields_4() {

		// now each row has different numbers of columns - capture when it has at least 3
		String TSVContent = "1\t2\t3\t4\n5\t6\n7\t8\t9\n10\n";
		List<String> correctAnswer = Arrays.asList("1","3","7","9");

		List<String> compositionAnswer = tsvParser
				.captureFirstAndThirdFields(TSVContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
