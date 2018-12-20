package compose.match;

import java.util.regex.Pattern;

public class OutlineFormat {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * This function should take this one line and determine if it looks like an
	 * outline. It should return true if at the beginning of the string, it has
	 * 0 or more whitespace characters followed by one of the following outline
	 * characters: 1 or more digits, a single lowercase letter, a single
	 * uppercase letter, or several 'i's in a row. Don't worry about roman
	 * numerals, bullets or other possible outline starting characters. After
	 * the outline character(s), you should always see a period '.' followed by
	 * at least one whitespace character. Whatever remains does not matter.
	 * 
	 */
	public boolean isOutlineFormat(String line) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		return Pattern.matches(regex, line);
	}

}
