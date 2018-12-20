package compose.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoGremlins {

	/**
	 * Gremlins are invisible characters that sometimes sneak into a text
	 * document. Return true if the entire input contains no 
	 * form-feed or carriage return characters.
	 * 
	 */
	public boolean noGremlinsFound(String anyText) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(anyText);
		return matcher.find();
	}
}
