package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TSVParser {

	/**
	 * A tab-separated values file has fields separated by tabs (fields have 1
	 * or more characters, and do not contain tab characters or newline
	 * characters). Lines are delimited by newlines. Capture the first and third
	 * fields of each line.
	 * 
	 */
	public List<String> captureFirstAndThirdFields(String TSVContent) {
		List<String> fields = new LinkedList<String>();

		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(TSVContent);
		while (matcher.find()) {
			fields.add(matcher.group(1));
			fields.add(matcher.group(2));
		}

		return fields;
	}

}
