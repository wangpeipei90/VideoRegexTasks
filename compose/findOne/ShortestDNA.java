package compose.findOne;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortestDNA {

	/**
	 * A line of text will contain at most one newline and only then at the end
	 * of the string (this input will not have multiple lines).
	 * 
	 * capture the SHORTEST sequence of DNA base pairs where we see AT...GC.
	 * This does not require that anything is in between, so for the sequence
	 * ACATGCC, just capture ATGC. But for the sequence ATATATATCCCGCGCGCGC, you
	 * must capture ATCCCGC.
	 * 
	 */
	/**
	 * expand to see hint:*****************************************************
	 * think about how to exclude the prefix (AT) from appearing in the sequence
	 * between it and the suffix (GC) between. It's a hard problem, so try this
	 * SO article: http://stackoverflow
	 * .com/questions/1232220/how-to-non-greedy-multiple-lookbehind-matches
	 **/
	public String captureShortestDNA(String content) {
		List<String> allShortest = new LinkedList<String>();

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			allShortest.add(matcher.group(1));
		}
		return shortestStringInList(allShortest);
	}

	private String shortestStringInList(List<String> allShortest) {
		if (allShortest.size() == 0) {
			return "";
		} else {
			Iterator<String> it = allShortest.iterator();
			String shortest = it.next();
			while (it.hasNext()) {
				String dna = it.next();
				shortest = dna.length() < shortest.length() ? dna : shortest;
			}
			return shortest;
		}
	}

}
