package compose.match;

import java.util.regex.Pattern;

public class ValidEmail {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * This function should take one line of text and verify that the entire
	 * string is composed of one valid email. Extra characters like whitespace
	 * before or after, or anything that would invalidate the email are not
	 * allowed (except newline at the end).
	 * 
	 */
	public boolean isValidEmail(String line) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		return Pattern.matches(regex, line);
	}
}
