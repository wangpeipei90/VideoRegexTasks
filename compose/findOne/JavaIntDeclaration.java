package compose.findOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaIntDeclaration {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * capture the value of an int constant declared on a line. For example
	 * "int x = 55;" should capture "55" but "int x = y;" should not capture
	 * anything.
	 * 
	 */
	public String captureIntConstant(String javaCode) {
		String constant = "";

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(javaCode);
		if (matcher.find()) {
			constant = matcher.group(1);
		}

		return constant;
	}

}
