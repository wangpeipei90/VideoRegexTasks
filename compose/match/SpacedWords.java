package compose.match;

import java.util.regex.Pattern;

public class SpacedWords {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * This function should take one line of text and return true if that line
	 * has only alphanumeric strings separated by whitespace. So "aaa b1b2b"
	 * should return true, but "aaa, ggg" should return false. A string with
	 * only whitespace or only alphanumeric words (not both) should return false
	 * 
	 */
	public boolean isSpacedWords(String line) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		return Pattern.matches(regex, line);
	}
}