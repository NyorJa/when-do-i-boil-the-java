package org.wecancodeit.whendoiboilthewater.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wecancodeit.whendoiboilthewater.models.Ingredient;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.models.Step;
import org.wecancodeit.whendoiboilthewater.repositories.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;
import org.wecancodeit.whendoiboilthewater.repositories.RecipeRepository;
import org.wecancodeit.whendoiboilthewater.repositories.StepRepository;

@Service
public class RecipeService {

	@Resource IngredientRepository ingredientRepo;
	@Resource MealRepository mealRepo;
	@Resource RecipeRepository recipeRepo;
	@Resource StepRepository stepRepo;

	public RecipeService() {
		super();
	}

	public Step addNewStep(Long stepLength, String stepDescription) {
		return stepRepo.save(new Step(stepLength, stepDescription));
	}

	public Ingredient addNewIngredient(String ingredientName) {
		return ingredientRepo.save(new Ingredient(ingredientName));
	}

	public Ingredient addNewIngredient(String ingredientName, String ingredientQuantity) {
		return ingredientRepo.save(new Ingredient(ingredientName, ingredientQuantity));
	}

	public Recipe addNewRecipe(String recipeName, int servingSize, String recipeDescription) {
		return recipeRepo.save(new Recipe(recipeName, servingSize, recipeDescription));
	}

	public Recipe addNewRecipe(String recipeName, int servingSize) {
		return recipeRepo.save(new Recipe(recipeName, servingSize));
	}

	public Recipe addNewRecipe(String recipeName) {
		return recipeRepo.save(new Recipe(recipeName));
	}

	public Meal addNewMeal(String mealName) {
		return mealRepo.save(new Meal(mealName));
	}

	public void addIngredientsToRecipe(Recipe recipe, Ingredient... ingredientsToAdd) {
		for (Ingredient ingredient : ingredientsToAdd) {
			addRecipeIngredient(ingredient, recipe);
			ingredientRepo.save(ingredient);
		}
		recipeRepo.save(recipe);
	}

	public void addRecipeIngredient(Ingredient ingredientToAdd, Recipe recipeToAddIngredientTo) {
		recipeToAddIngredientTo.addIngredient(ingredientToAdd);
		ingredientToAdd.addRecipe(recipeToAddIngredientTo);
	}

	public void addStepsToRecipe(Recipe recipe, Step... stepsToAdd) {
		for (Step step : stepsToAdd) {
			addRecipeStep(step, recipe);
			stepRepo.save(step);
		}
		recipeRepo.save(recipe);
	}

	public void addRecipeStep(Step stepToAdd, Recipe recipeToAddStepTo) {
		recipeToAddStepTo.addStep(stepToAdd);
		stepToAdd.addRecipe(recipeToAddStepTo);
	}

	public void addRecipesToMeal(Meal meal, Recipe... recipesToAdd) {
		for (Recipe recipe : recipesToAdd) {
			addMealRecipe(recipe, meal);
		}
		mealRepo.save(meal);
	}

	public void addMealRecipe(Recipe recipeToAdd, Meal mealToAddRecipeTo) {
		mealToAddRecipeTo.addRecipe(recipeToAdd);
	}

}