package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.OnMinuteEvents;

public class OnMinuteEventsTest {

	private static OnMinuteEvents onMinuteEvents = null;

	@BeforeClass
	public static void setup() {
		onMinuteEvents = new OnMinuteEvents();
	}

	@Test
	public void testCaptureEvents_1() {
		
		//a simple log with four entries, two of which should be captured
		String logContent = "2015-02-09T02:54:00Z Siva took a nap\n2015-02-09T02:54:01Z Siva was snoring\n2015-02-09T03:01:00Z Coffee is served.\n2015-02-10T20:00:01Z Dragon went to sleep.";
		List<String> correctAnswer = Arrays.asList("Siva took a nap", "Coffee is served.");
		
		List<String> compositionAnswer = onMinuteEvents.captureEvents(logContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureEvents_2() {
		
		//some date strings are the wrong format, these should not be captured
		String logContent = "2015/02/09-02:54:00Z Siva took a nap\n2015-02-09T02:54:00Z Siva was snoring\n2015:02:09T03:01:00Z Coffee is served.\n2015-02-10T20:00:01Z Dragon went to sleep.";
		List<String> correctAnswer = Arrays.asList("Siva was snoring");
		
		List<String> compositionAnswer = onMinuteEvents.captureEvents(logContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureEvents_3() {
		
		//now some log times are invalid because something is missing
		String logContent = "2015-02:54:00Z Siva took a nap\n2015-02-09T02:54:01Z Siva was snoring\n2015-02-09T03:01:00Z Coffee is served.\n2015-02-10T20:00Z Dragon went to sleep.";
		List<String> correctAnswer = Arrays.asList("Coffee is served.");
		
		List<String> compositionAnswer = onMinuteEvents.captureEvents(logContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureEvents_4() {
		
		//this log only has one line - should be easier to pass this test
		String logContent = "2015-02-09T02:54:00Z Siva took a nap";
		List<String> correctAnswer = Arrays.asList("Siva took a nap");
		
		List<String> compositionAnswer = onMinuteEvents.captureEvents(logContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureEvents_5() {
		
		//now we are missing newlines - capture everything after the first valid timestamp
		String logContent = "2015-02-09T02:54:00Z Siva took a nap2015-02-09T02:54:01Z Siva was snoring2015-02-09T03:01:00Z Coffee is served.2015-02-10T20:00:01Z Dragon went to sleep.";
		List<String> correctAnswer = Arrays.asList("Siva took a nap2015-02-09T02:54:01Z Siva was snoring2015-02-09T03:01:00Z Coffee is served.2015-02-10T20:00:01Z Dragon went to sleep.");
		
		List<String> compositionAnswer = onMinuteEvents.captureEvents(logContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
