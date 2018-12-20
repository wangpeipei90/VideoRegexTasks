package test.findOne;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findOne.ShortestDNA;

public class ShortestDNATest {

	private static ShortestDNA shortestDNA = null;

	@BeforeClass
	public static void setup() {
		shortestDNA = new ShortestDNA();
	}

	@Test
	public void testCaptureShortestDNA_1() {
		
		//has several substrings that match - a little tricy
		String sequencedDNA = "CCGCACAAGTGGATGTGAGGCGATTGCCCGCTAAGATATTCTAACGTGTAACGCAGATGAGTATTCTACAG";
		String correctAnswer = "ATTGC";

		String compositionAnswer = shortestDNA.captureShortestDNA(sequencedDNA);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureShortestDNA_2() {
		
		//empty input does not match anything
		String sequencedDNA = "";
		String correctAnswer = "";

		String compositionAnswer = shortestDNA.captureShortestDNA(sequencedDNA);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureShortestDNA_3() {
		
		//somehow this does not have the pattern anywhere, despite having lots of AT
		String sequencedDNA = "GCAAACGTATTATTGAGGAATTATATATCCATAAACTACAATGGATTCAACTTAATCAAAAT";
		String correctAnswer = "";

		String compositionAnswer = shortestDNA.captureShortestDNA(sequencedDNA);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureShortestDNA_4() {
		
		//the shortest match here is not very short - also has more AT than GC
		String sequencedDNA = "GAATAATAATAGTTATAAATACTAAACTAAAACAACAGTCAAGTGTACTAACTAGCTTTTGGT";
		String correctAnswer = "ATACTAAACTAAAACAACAGTCAAGTGTACTAACTAGC";

		String compositionAnswer = shortestDNA.captureShortestDNA(sequencedDNA);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureShortestDNA_5() {
		
		//another example
		String sequencedDNA = "CCCGAGAAGGCTGTGCCTGGGCTCAACCGGAGGCAGGATGGACCCCAGACACGGGGCCACATGGACCCCACCAACACACTTCAAAGACACGGGGC";
		String correctAnswer = "ATGGACCCCAGACACGGGGC";

		String compositionAnswer = shortestDNA.captureShortestDNA(sequencedDNA);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
