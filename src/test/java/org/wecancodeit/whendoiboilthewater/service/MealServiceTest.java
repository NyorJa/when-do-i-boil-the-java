package org.wecancodeit.whendoiboilthewater.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.models.Step;
import org.wecancodeit.whendoiboilthewater.services.MealService;

import javax.transaction.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class MealServiceTest {

    @Autowired
    private MealService mealService;

    @Transactional
    @Test
    public void testAddRecipesToMeal() {

        Meal meal = new Meal();
        meal.setName("Happy meal");
        Step step = new Step(20L, "desc-2");
        Recipe recipe = new Recipe("butsbak", 1, "das");
        recipe.addStep(step);

        mealService.addRecipesToMeal(meal, recipe);
    }
}
