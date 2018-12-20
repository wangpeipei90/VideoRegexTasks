package test.findMany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findMany.ReceiptScanner;

public class ReceiptScannerTest {

	private static ReceiptScanner receiptScanner = null;

	@BeforeClass
	public static void setup() {
		receiptScanner = new ReceiptScanner();
	}

	@Test
	public void testCaptureStoreAndValue_1() {

		// Here is a basic example of a small receipt
		String scannedReceiptText = "   HyVee  \neggs\t2.19  \nmilk\t3.69\n subtotal 5.88\ntax 0.47\n total 6.35";
		List<String> correctAnswer = Arrays.asList("HyVee", "6.35");

		List<String> compositionAnswer = receiptScanner
				.captureStoreAndValue(scannedReceiptText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureStoreAndValue_2() {

		// non-conforming inputs like this one should just be empty
		String scannedReceiptText = "how did this get here?";
		List<String> correctAnswer = Arrays.asList();

		List<String> compositionAnswer = receiptScanner
				.captureStoreAndValue(scannedReceiptText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureStoreAndValue_3() {

		// Here is another receipt with a dollar sign
		String scannedReceiptText = "Git-n-Split\ngas 200.00\ntax 0.00\n total $200.00";
		List<String> correctAnswer = Arrays.asList("Git-n-Split", "200.00");

		List<String> compositionAnswer = receiptScanner
				.captureStoreAndValue(scannedReceiptText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
	
	@Test
	public void testCaptureStoreAndValue_4() {

		// Here is another receipt with a dollar sign
		String scannedReceiptText = "\t\tLarry's fruit stand\n4 apples: $4\ntax 0.00\n total $4";
		List<String> correctAnswer = Arrays.asList("Larry's fruit stand", "4");

		List<String> compositionAnswer = receiptScanner
				.captureStoreAndValue(scannedReceiptText);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}
}
