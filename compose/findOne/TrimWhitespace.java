package compose.findOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrimWhitespace {

	/**
	 * This function should exactly match java's String.trim() functionality. It
	 * removes whitespace from the beginning and end of the string.
	 * 
	 */
	public String trimWhitespace(String content) {
		String trimmedContent = "";

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()) {
			trimmedContent=matcher.group(1);
		}

		return trimmedContent;
	}

}
