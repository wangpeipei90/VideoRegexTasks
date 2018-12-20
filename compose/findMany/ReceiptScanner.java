package compose.findMany;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptScanner {

	/**
	 * A receipt-scanning engine transforms a photograph into a block of text,
	 * with separate lines delimited by newline. The photo is framed so that the
	 * store name is on the first line. After 0 or more spaces, the rest of the
	 * text is the store name, except for 0 or more spaces at the end of that
	 * line. The total cost is on the last line. When stating the total price,
	 * some vendors include the '$' symbol before the amount, and some do not
	 * include any 'cents' information. Capture the name of the store and the
	 * full dollar value, with cents information if included, but without any
	 * '$' symbols. So for examples of the total value: "$8.91" captures "8.91",
	 * and "1.25" captures "1.25", and "$14" or "14" both capture "14".
	 * 
	 */
	/**
	 * expand to see hint:****************************************************
	 * the capture group indexing will span across an '|' (logical or) if you
	 * use an '|', like "...(group1)...|...(group2)..."
	 */
	public List<String> captureStoreAndValue(String scannedReceiptText) {
		List<String> storeAndValue = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(scannedReceiptText);

		try {
			// first time we match, it must be the store name
			matcher.find();
			storeAndValue.add(matcher.group(1));

			// second time must be the last amount
			matcher.find();
			storeAndValue.add(matcher.group(2));

			// on exception, return the list as it is
		} catch (Exception e) {
		}

		return storeAndValue;
	}

}
