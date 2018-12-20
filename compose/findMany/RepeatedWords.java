package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedWords {

	/**
	 * capture a repeated word where any word repeats 2 or more times in a row.
	 * A word can contain lowercase and uppercase letters, numbers or the
	 * underline. words that repeat are separated by a space or a comma and then
	 * a space. example: "It has been a very, very good day." should capture
	 * "very". The search is not case sensitive so a flag has been included.
	 * 
	 * @param textBlock
	 * @return
	 */
	public List<String> captureReapeatedWords(String textBlock) {
		List<String> repeats = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(textBlock);
		while (matcher.find()) {
			repeats.add(matcher.group(1));
		}

		return repeats;
	}

}
