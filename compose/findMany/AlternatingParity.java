package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * capture an integer that alternates between odd and even digits. These
 * integers can have nothing or any non-digit character on either side." 1256 "
 * should capture "1256" and "abc.345" should capture "345". But "1" and "1.2.3"
 * should not capture anything because there is no alternation with only one
 * digit. Numbers like "112" and "721433" do not alternate parity consistently,
 * and should be ignored, including subsets like "12" and "72143" that do
 * alternate.
 */
public class AlternatingParity {

	public List<String> captureIntegerPortion(String content) {
		List<String> integerPortions = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			integerPortions.add(matcher.group(0));
		}

		return integerPortions;
	}

}
