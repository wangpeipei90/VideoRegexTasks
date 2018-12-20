package compose.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
	static List<String> capturedEvents = new LinkedList<String>();

	public static List<String> captureMany(String testString) {
		
		String regex = "initially fails";
		//String regex = "(ab+c)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(testString);
		while (matcher.find()) {
			capturedEvents.add(matcher.group(1));
		}

		return capturedEvents;
	}
	
	public String captureFirst(String testString) {
		
		String first = "";
		
		String regex = "initially fails";
		//String regex = "(ab+c)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(testString);
		if (matcher.find()) {
			first = matcher.group(1);
		}

		return first;
	}
	
	public boolean isMatching(String testString) {

		String regex = "initially fails";
		//String regex = "ab+c";
		return Pattern.matches(regex, testString);
	}
	
	public boolean isFound(String testString) {

		String regex = "initially fails";
		//String regex = "ab+c";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(testString);
		return matcher.find();
	}


}
