package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerbPortion {

	/**
	 * look for verbs that end with "ing", and capture the verb portion, so
	 * "sitting, cooking and cleaning" should capture "sitt", "cook","clean"
	 * 
	 */
	public List<String> captureVerbs(String content) {
		List<String> verbs = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			verbs.add(matcher.group(1));
		}

		return verbs;
	}

}
