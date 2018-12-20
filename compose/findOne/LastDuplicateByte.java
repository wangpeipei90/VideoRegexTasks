package compose.findOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastDuplicateByte {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * Hex values include characters from 0123456789ABCDEF for a total of 16
	 * possible characters. Two of these values together can represent a byte
	 * with 8 bits, taking on values from 0 to 255 inclusive. Groups of bytes
	 * are often represented by space-separated pairs of hex values. From this
	 * type of input, capture the last byte that has a duplicate byte somewhere
	 * after it, so for example: "A1 C3 B2 A1 02 00 04 04 00" should capture
	 * "04". You do not have to verify the type of input, so
	 * "abcdefg 7D 7D hijklmnop" should capture "7D".
	 * 
	 */
	public String captureLastDuplicateByte(String content) {
		String byteString = "";

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			byteString = matcher.group(1);
		}

		return byteString;
	}

}
