package compose.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoVowelsWord {

	/**
	 * Returns true if any alphanumeric word in the text contains no vowels. So
	 * the strange sentence: "I have ctmpts training to go to!" should return
	 * true. Input does not need to be a sentence, and words are separated by
	 * whitespace as usual, ignoring punctuation. Words are composed of 2 or
	 * more lowercase or uppercase letters.
	 * 
	 */
	public boolean hasNoVowelsWord(String content) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		return matcher.find();
	}
}
