package compose.match;

import java.util.regex.Pattern;

public class ReverseSentences {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * We are all familiar with the rules for constructing a valid sentence:
	 * start with a capitol letter, end with a period. There are other
	 * requirements for valid sentences, and sentences can end with exclamation
	 * points or question marks, but you can ignore these finer points for now.
	 * Sentences are separated from each other by one or more space characters.
	 * Words are never composed of space characters, and are separated by space
	 * characters.
	 * 
	 * This function returns true if a line is composed of one or more valid
	 * REVERSE sentences. Here is a very short example:
	 * ".uoy did oS .emoh deklaw I"
	 * 
	 */
	public boolean isReversedSentences(String line) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		return Pattern.matches(regex, line);
	}

}
