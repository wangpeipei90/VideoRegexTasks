package test.findOne;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.findOne.JavaIntDeclaration;

public class JavaIntDeclarationTest {

	private static JavaIntDeclaration javaIntDeclaration = null;

	@BeforeClass
	public static void setup() {
		javaIntDeclaration = new JavaIntDeclaration();
	}

	@Test
	public void testCaptureIntConstant_1() {

		// a basic integer declaration
		String javaCode = "int x = 23;";
		String correctAnswer = "23";

		String compositionAnswer = javaIntDeclaration.captureIntConstant(javaCode);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntConstant_2() {

		// a potentially valid declaration which may have a variable as a value
		// ignore this
		String javaCode = "int abcdefg = z";
		String correctAnswer = "";

		String compositionAnswer = javaIntDeclaration.captureIntConstant(javaCode);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntConstant_3() {
		
		//valid with weird spacing - capture this
		String javaCode = "   int number =    1;";
		String correctAnswer = "1";

		String compositionAnswer = javaIntDeclaration.captureIntConstant(javaCode);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntConstant_4() {
		
		//not a valid java variable name
		String javaCode = "int .cdef=405;";
		String correctAnswer = "";

		String compositionAnswer = javaIntDeclaration.captureIntConstant(javaCode);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

	@Test
	public void testCaptureIntConstant_5() {
		
		//does not parse as a declaration
		String javaCode = "int 555 = x int = 1209";
		String correctAnswer = "";

		String compositionAnswer = javaIntDeclaration.captureIntConstant(javaCode);
		assertThat(compositionAnswer, equalTo(correctAnswer));
	}

}
