package org.wecancodeit.whendoiboilthewater.model;

import org.junit.Assert;
import org.junit.Test;

public class RecipeTest {
	@Test
	public void shouldBeAsLongAsItsSteps() {
		Recipe recipe1 = new Recipe("testipe", 4, "");
		Long lengthOfStep = 30L;
		Step step1 = new Step(lengthOfStep, "");
		recipe1.addStep(step1);
		
		Assert.assertEquals(recipe1.getLength(), lengthOfStep);
	}
	
	@Test
	public void shouldAddIngredient() {
		Recipe recipe1 = new Recipe("testipe", 4, "");
		Step step1 = new Step(0L, "");
		recipe1.addStep(step1);
		Ingredient ingredient = new Ingredient("foo");
		recipe1.addIngredient(ingredient);
		
		Assert.assertEquals(recipe1.getIngredients().contains(ingredient), true);
	}
}
