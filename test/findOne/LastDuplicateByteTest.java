package test.findOne;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findOne.LastDuplicateByte;

public class LastDuplicateByteTest {

	private static LastDuplicateByte lastDuplicateByte = null;

	@BeforeClass
	public static void setup() {
		lastDuplicateByte = new LastDuplicateByte();
	}

	@Test
	public void testCaptureLastDuplicateByte_1() {
		
		// many duplicates
		String byteContent = "09 09 2F 2F 50 61 74 74 65 72 6E 20 70 20 3D 20 50 61 74 74 65 72 6E 2E";
		String correctAnswer = "74";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureLastDuplicateByte_2() {
		
		//only one byte - no duplicates possible
		String byteContent = "0A";
		String correctAnswer = "";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureLastDuplicateByte_3() {
		
		//two valid bytes appear in this list of two letter words
		String byteContent = "as as if if AF AF of of at at to to no no uh uh me me";
		String correctAnswer = "AF";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureLastDuplicateByte_4() {
		
		//no duplicates, even in this rather long series
		String byteContent = "08 09 2F AA 40 A1 7B 7A 15 12 6F 20 70 21 3D 22 50 61 74 71 65 72 6E 2E";
		String correctAnswer = "";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureLastDuplicateByte_5() {
		
		//simple pair - yes it is a duplicate
		String byteContent = "09 09";
		String correctAnswer = "09";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureLastDuplicateByte_6() {
		
		//capture the last one with a duplicate after it: FF, not 10
		String byteContent = "10 FF FF 10";
		String correctAnswer = "FF";
		
		String compositionAnswer = lastDuplicateByte.captureLastDuplicateByte(byteContent);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
