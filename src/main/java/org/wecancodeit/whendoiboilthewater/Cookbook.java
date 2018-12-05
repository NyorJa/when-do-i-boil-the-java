package org.wecancodeit.whendoiboilthewater;

import javax.annotation.Resource;

import org.wecancodeit.whendoiboilthewater.model.Ingredient;
import org.wecancodeit.whendoiboilthewater.model.Meal;
import org.wecancodeit.whendoiboilthewater.model.Recipe;
import org.wecancodeit.whendoiboilthewater.model.Step;
import org.wecancodeit.whendoiboilthewater.repository.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repository.MealRepository;
import org.wecancodeit.whendoiboilthewater.repository.RecipeRepository;
import org.wecancodeit.whendoiboilthewater.repository.StepRepository;

public class Cookbook {

	@Resource
	IngredientRepository ingredientRepo;
	@Resource
	MealRepository mealRepo;
	@Resource
	protected RecipeRepository recipeRepo;
	@Resource
	StepRepository stepRepo;

	public Cookbook() {
		super();
	}

	protected Step addNewStep(Long stepLength, String stepDescription) {
		return stepRepo.save(new Step(stepLength, stepDescription));
	}

	protected Ingredient addNewIngredient(String ingredientName) {
		return ingredientRepo.save(new Ingredient(ingredientName));
	}

	protected void addIngredientsToRecipe(Recipe recipe, Ingredient... ingredientsToAdd) {
		for (int i = 0; i < ingredientsToAdd.length; i++) {
			addRecipeIngredient(ingredientsToAdd[i], recipe);
		}
	}

	protected void addStepsToRecipe(Recipe recipe, Step... stepsToAdd) {
		for (int i = 0; i < stepsToAdd.length; i++) {
			addRecipeStep(stepsToAdd[i], recipe);
		}
	}

	protected void addRecipesToMeal(Meal meal, Recipe... recipesToAdd) {
		for (int i = 0; i < recipesToAdd.length; i++) {
			addMealRecipe(recipesToAdd[i], meal);
		}
	}

	protected void addMealRecipe(Recipe recipeToAdd, Meal mealToAddRecipeTo) {
		mealToAddRecipeTo.addRecipe(recipeToAdd);
		mealRepo.save(mealToAddRecipeTo);
	}

	protected void addRecipeIngredient(Ingredient ingredientToAdd, Recipe recipeToAddIngredientTo) {
		recipeToAddIngredientTo.addIngredient(ingredientToAdd);
		ingredientToAdd.addRecipe(recipeToAddIngredientTo);
		recipeRepo.save(recipeToAddIngredientTo);
		ingredientRepo.save(ingredientToAdd);
	}

	protected void addRecipeIngredientWithQuantity(Ingredient ingredientToAdd, String ingredientQuantity,
			Recipe recipeToAddIngredientTo) {
		recipeToAddIngredientTo.addIngredient(ingredientToAdd);
		recipeToAddIngredientTo.addIngredientToList(ingredientToAdd, ingredientQuantity);
		ingredientToAdd.addRecipe(recipeToAddIngredientTo);
		recipeRepo.save(recipeToAddIngredientTo);
		ingredientRepo.save(ingredientToAdd);
	}

	protected void addRecipeStep(Step stepToAdd, Recipe recipeToAddStepTo) {
		recipeToAddStepTo.addStep(stepToAdd);
		stepToAdd.addRecipe(recipeToAddStepTo);
		recipeRepo.save(recipeToAddStepTo);
		stepRepo.save(stepToAdd);
	}

}