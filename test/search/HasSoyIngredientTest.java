package test.search;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import compose.search.HasSoyIngredient;

public class HasSoyIngredientTest {

	private static HasSoyIngredient hasSoyIngredient = null;

	@BeforeClass
	public static void setup() {
		hasSoyIngredient = new HasSoyIngredient();
	}

	@Test
	public void testHasSoyIngredient_1() {

		// a soy free recipe for tea cookies
		String ingredientsList = "butter, sugar, tea leaves, flour, salt, vanilla";
		boolean correctAnswer = false;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_2() {

		// lots of soy ingredients without the word soy
		String ingredientsList = "Edamame, salt, Okara, Miso, Shoyu";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_3() {

		// Natto and tofu are on the list
		String ingredientsList = "Natto, tofu, pesto, noodles, magnifying glass";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_4() {

		// Kinnoko flour and Kyodofu are both on the list
		String ingredientsList = "Kinnoko flour, Kyodofu fried in Canola oil";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_5() {

		// ingredients that actually say 'soy' should be easy to detect
		String ingredientsList = "every ingredient1, any ingredient2, soy, soy sauce, soy anything";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_6() {

		// these use the word 'soybean' - another dead giveaway
		String ingredientsList = "soybean oil, soybean flour, soybean curd, soybean paste";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_7() {

		// soya is another name for soy
		String ingredientsList = "soya, Soya Flour";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_8() {

		// These are more words for soy-based foods
		String ingredientsList = "Supro, Tamari, Tempeh, Teriyaki sauce";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_9() {

		// vegetable protein is soy, which is strange because soy beans are not
		// vegetables
		String ingredientsList = "vegetable protein, flour, glue, gummy bears";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_10() {

		// Yakidofu is basically just tofu I think
		String ingredientsList = "Yakidofu, oranges, peaches, red pepper flakes";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_11() {

		// Yuba curd is soy-based.
		String ingredientsList = "Yuba curd, tiger fur, mace and ethenol";
		boolean correctAnswer = true;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_12() {

		// Paduasoy is one of the only words in the world that has the word soy
		// in it - it is a type of ancient silk cloth
		String ingredientsList = "angel food cake, Paduasoy cloth, steam water";
		boolean correctAnswer = false;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_13() {
		
		//the other existing word is a name for a Russian space capsule
		String ingredientsList = "Soyuzes space capsule and three monkeys inside";
		boolean correctAnswer = false;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

	@Test
	public void testHasSoyIngredient_14() {
		
		//these characters are not valid
		String ingredientsList = "14893-02157493201-;',./[]\\-=-=-=-=-=-=-=-=";
		boolean correctAnswer = false;

		boolean compositionAnswer = hasSoyIngredient.hasSoyIngredient(ingredientsList);
		assertTrue(compositionAnswer == correctAnswer);
	}

}
