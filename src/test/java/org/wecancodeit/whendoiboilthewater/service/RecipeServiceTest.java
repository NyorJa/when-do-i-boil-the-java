package org.wecancodeit.whendoiboilthewater.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.wecancodeit.whendoiboilthewater.models.Ingredient;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.models.Step;
import org.wecancodeit.whendoiboilthewater.services.RecipeService;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Test
    public void testAddNewIngredient() {
        Ingredient actual = recipeService.addNewIngredient("boras", "2 kg");

        assertEquals("boras", actual.getName());
        assertEquals("2 kg", actual.getQuantity());
    }

    @Test
    public void testAddNewIngredient2() {
        Ingredient actual = recipeService.addNewIngredient("salt");

        assertEquals("salt", actual.getName());
    }

    @Test
    public void testAddNewRecipe() {
        Recipe actual = recipeService.addNewRecipe("Sisig", 10);
        assertEquals("Sisig", actual.getName());
        assertEquals(10, actual.getServingSize());
    }

    @Test
    public void testAddNewRecipe2() {
        Recipe actual = recipeService.addNewRecipe("Kansi");
        assertEquals("Kansi", actual.getName());
    }

    @Test
    public void testAddNewMeal() {
        Meal actual = recipeService.addNewMeal("Kiddy Meal");
        assertEquals("Kiddy Meal", actual.getName());
    }

    @Transactional
    @Test
    public void testAddIngredientsToRecipe() {
        Recipe recipe = new Recipe("tocilog", 1, "tocino itlog");
        Ingredient ingredient = new Ingredient("itlog");

        recipeService.addIngredientsToRecipe(recipe, ingredient);

        assertEquals("itlog", recipe.getIngredients().stream().collect(Collectors.toList()).get(0).getName());

    }

    @Transactional
    @Test
    public void testAddStepsToRecipe() {
        Recipe recipe = new Recipe("kaplog", 1, "kape itlog");
        Step step = new Step(2L, "step3");
        recipeService.addStepsToRecipe(recipe, step);

        assertFalse(CollectionUtils.isEmpty(recipe.getSteps()));
    }

    @Transactional
    @Test
    public void testRecipesToMeal() {
        Meal meal = new Meal("bitesize");
        Recipe recipe = new Recipe("bacilo", 1, "bacon itlog");

        recipeService.addRecipesToMeal(meal, recipe);

        assertFalse(CollectionUtils.isEmpty(meal.getRecipes()));
    }
}
