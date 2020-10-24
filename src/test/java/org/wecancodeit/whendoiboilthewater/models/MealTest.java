package org.wecancodeit.whendoiboilthewater.models;

import org.junit.Assert;
import org.junit.Test;

public class MealTest {
	@Test
	public void shouldCalculateLength() {
		Meal undertest = new Meal("test");
		Recipe recipe1 = new Recipe("testipe", 4, "");
		
		Long lengthOfStep = 30L;
		Step step1 = new Step(lengthOfStep, "");
		
		recipe1.addStep(step1);
		undertest.addRecipe(recipe1);
		
		Assert.assertEquals(undertest.getLength(), lengthOfStep);
	}
}
