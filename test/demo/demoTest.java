package test.demo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.demo.demo;


public class demoTest {


		private static demo demoInstance = null;

		@BeforeClass
		public static void setup() {
			demoInstance = new demo();
		}

		@Test
		public void testAlwaysPasses() {	
			assert(1 > 0);
		}

		@Test
		public void findMany_ExampleTest() {
			
			// capture multiple parts that match 'ab+c'
			String testString = "abcabbc";
			List<String> correctAnswer = Arrays.asList("abc","abbc");
			
			List<String> compositionAnswer = demo.captureMany(testString);
			assertThat(compositionAnswer, equalTo(correctAnswer));
		}

		@Test
		public void findOne_ExampleTest() {
			
			//capture the first part that matches 'ab+c' (but not 'ab*c')
			String testString = "acabcabbc";			
			String correctAnswer = "abc";
			
			String compositionAnswer = demoInstance.captureFirst(testString);
			assertThat(compositionAnswer, equalTo(correctAnswer));
		}

		@Test
		public void match_ExampleTest() {
			//this whole string has to match 'ab+c'
			String line = "abbbbbbbc";
			boolean correctAnswer = true;

			boolean compositionAnswer = demoInstance.isMatching(line);
			assertTrue(compositionAnswer == correctAnswer);
		}

		@Test
		public void search_ExampleTest() {
			
			String anyLine = "xyzabcefg";
			boolean correctAnswer = true;

			boolean compositionAnswer = demoInstance.isFound(anyLine);
			assertTrue(compositionAnswer == correctAnswer);
		}

}
