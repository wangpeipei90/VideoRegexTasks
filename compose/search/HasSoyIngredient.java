package compose.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasSoyIngredient {

	/**
	 * soy allergy: food ingredient lists have various names for soy-based
	 * ingredients. Return true if the multi-line ingredient list contains any
	 * of the words found on in the "contain soy" list:
	 * http://www.kidswithfoodallergies.org/resourcespre.php?id=51
	 * 
	 */
	public boolean hasSoyIngredient(String ingredientsList) {

		// TODO compose a regex to complete the challenge
		String regex = "";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(ingredientsList);
		return matcher.find();
	}

}
