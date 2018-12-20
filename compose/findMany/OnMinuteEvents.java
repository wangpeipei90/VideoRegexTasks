package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnMinuteEvents {

	/**
	 * For lines of log files starting with an ISO timestamp, return everything
	 * after the ISO timestamp if the timestamp denotes something that happened
	 * at an exact minute, so example line:
	 * "2015-02-09T02:54:00Z Siva took a nap" should capture "Siva took a nap".
	 * The timestamp will always follow the pattern shown in this example and
	 * the content to capture will always be everything on that line following
	 * the block of whitespace after the timestamp. However, you should not
	 * capture anything that has not happened on the minute, so
	 * "2015-03-02T16:18:21Z Siva ate her treat" should not capture anything
	 * because the seconds field is "21" not "00". Each line of the logs will be
	 * newline-separated.
	 * 
	 */
	public List<String> captureEvents(String logContent) {
		List<String> onMinuteEvents = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(logContent);
		while (matcher.find()) {
			onMinuteEvents.add(matcher.group(1));
		}

		return onMinuteEvents;
	}

}
