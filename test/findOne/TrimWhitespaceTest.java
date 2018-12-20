package test.findOne;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findOne.TrimWhitespace;

public class TrimWhitespaceTest {

	private static TrimWhitespace trimWhitespace = null;

	@BeforeClass
	public static void setup() {
		trimWhitespace = new TrimWhitespace();
	}

	@Test
	public void testTrimWhitespace_1() {
		
		//trimming just spaces
		String anyText = "  four score and   ";
		String correctAnswer = "four score and";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testTrimWhitespace_2() {
		
		//trimming some non-space whitespace
		String anyText = "\t\t\t\tseven years ago\f\f\f";
		String correctAnswer = "seven years ago";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testTrimWhitespace_3() {
		
		//trimming newlines - can be a little trickier
		String anyText = "\n\n\nour\nfathers\n";
		String correctAnswer = "our\nfathers";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testTrimWhitespace_4() {
		
		//if there is no whitespace, don't trim anything
		String anyText = "brought forth on this continent a new nation,";
		String correctAnswer = "brought forth on this continent a new nation,";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testTrimWhitespace_5() {
		
		//a larger example
		String anyText = "              \t\t\t\n\f\rconceived in liberty, and dedicated to the proposition that all men are created equal.\n\nNow we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battlefield of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.\n\nBut, in a larger sense, we can not dedicate, we can not consecrate, we can not hallow this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us—that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion—that we here highly resolve that these dead shall not have died in vain—that this nation, under God, shall have a new birth of freedom—and that government of the people, by the people, for the people, shall not perish from the earth.";
		String correctAnswer = "conceived in liberty, and dedicated to the proposition that all men are created equal.\n\nNow we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battlefield of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.\n\nBut, in a larger sense, we can not dedicate, we can not consecrate, we can not hallow this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us—that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion—that we here highly resolve that these dead shall not have died in vain—that this nation, under God, shall have a new birth of freedom—and that government of the people, by the people, for the people, shall not perish from the earth.";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testTrimWhitespace_6() {
		
		//all whitespace - trim it all!
		String anyText = "\n\n\n\t\t\t\r\r\r\f\f\f   ";
		String correctAnswer = "";

		String compositionAnswer = trimWhitespace.trimWhitespace(anyText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
