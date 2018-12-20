package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessedPossessions {

	/**
	 * find the next word after any word ending with apostrophe-s, examples:
	 * "Dragon's cat" should capture "cat". "it's raining" should capture
	 * "raining". In this case, a 'word' is always composed of at least two
	 * lowercase or uppercase letters. The word with the apostrophe-s may be
	 * separated from the captured word by a single space, or a comma followed
	 * by a space.
	 * 
	 */
	public List<String> capturePossessions(String anyText) {
		List<String> possessions = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(anyText);
		while (matcher.find()) {
			possessions.add(matcher.group(1));
		}

		return possessions;
	}

}
