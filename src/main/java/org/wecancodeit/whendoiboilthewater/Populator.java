package org.wecancodeit.whendoiboilthewater;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.whendoiboilthewater.model.Ingredient;
import org.wecancodeit.whendoiboilthewater.model.Meal;
import org.wecancodeit.whendoiboilthewater.model.Recipe;
import org.wecancodeit.whendoiboilthewater.model.Step;
import org.wecancodeit.whendoiboilthewater.repository.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repository.MealRepository;
import org.wecancodeit.whendoiboilthewater.repository.RecipeRepository;
import org.wecancodeit.whendoiboilthewater.repository.StepRepository;

@Service
public class Populator extends Cookbook implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Ingredient farfalle = addNewIngredient("farfalle");
		Ingredient popRocks = addNewIngredient("Pop Rocks");
		Ingredient hotDog = addNewIngredient("Hot Dogs");
		Ingredient cheeto = addNewIngredient("cheeto");
		Ingredient navyBean = addNewIngredient("addNewIngredientNavy Bean");
		Ingredient pintoBean = addNewIngredient("Pinto Bean");
		Ingredient lightKidneyBean = addNewIngredient("Light Kidney Bean");
		Ingredient darkKidneyBean = addNewIngredient("Dark Kidney Bean");
		Ingredient garbanzoBean = addNewIngredient("Garbanzo Bean");
		Ingredient butterBean = addNewIngredient("Butter Bean");
		Ingredient bakedBean = addNewIngredient("Baked Bean");
		Ingredient favaBean = addNewIngredient("Fava Bean");
		Ingredient cannelliniBean = addNewIngredient("Cannellini Bean");
		Ingredient flageoletBean = addNewIngredient("Flageolet Bean");
		Ingredient milk = addNewIngredient("Milk");
		Ingredient tapiocaBall = addNewIngredient("Tapioca Balls");

		Step step1 = addNewStep(600L, "boil the pop rocks");
		Step step2 = addNewStep(300L, "dice the hot dogs");
		Step step3 = addNewStep(120L, "stir in the hot dogs");
		Step cheetoStep1 = addNewStep(66L, "Fry Cheeto");
		Step step4 = addNewStep(65L, "boil all them beans hard AF");
		Step step5 = addNewStep(60L, "drain all them beans");
		Step step6 = addNewStep(55L, "add the Navy Bean to the bowl");
		Step step7 = addNewStep(50L, "add the Pinto Bean to the bowl");
		Step step8 = addNewStep(45L, "add the Light Kidney Bean to the bowl");
		Step step9 = addNewStep(40L, "add the Dark Kidney Bean to the bowl");
		Step step10 = addNewStep(35L, "add the Garbanzo Bean to the bowl");
		Step step11 = addNewStep(30L, "add the Butter Bean to the bowl");
		Step step12 = addNewStep(25L, "add the Baked Bean to the bowl");
		Step step13 = addNewStep(20L, "add the Fava Bean to the bowl");
		Step step14 = addNewStep(15L, "add the Cannellini Bean to the bowl");
		Step step15 = addNewStep(10L, "add the FlageoletBean to the bowl");
		Step step16 = addNewStep(67L, "steep the hotdogs in nearly boiling water");
		Step step17 = addNewStep(42L, "remove hot dogs from water");
		Step step18 = addNewStep(37L, "add milk to hot dog tea");
		Step step19 = addNewStep(32L, "whisk together hot dog tea and milk");
		Step step20 = addNewStep(27L, "set aside hot dog milk tea");
		Step step21 = addNewStep(7L, "add tapioca balls to hot dog milk tea");

		Recipe recipe1 = recipeRepo.save(new Recipe("Hot Pop Rock Dog Stew", 12,
				"A frothy, exciting treat for a cold summer night. 1 cup Pop Rocks, 4 Hot Dogs, 2 cup Farfalle"));
		Recipe recipe2 = recipeRepo.save(new Recipe("Single Fried Cheeto", 4, "A delicacy."));
		Recipe recipe3 = recipeRepo
				.save(new Recipe("Quick 10-Bean Salad", 10, "Ten High Quality Beans for Ten High Quality Folks"));
		Recipe recipe4 = recipeRepo.save(new Recipe("Hot Dog Milk Tea Boba", 10,
				"Fancy bubble tea featuring your favorite of conglomerated meat products, the Hot Dog!"));

		Meal meal1 = new Meal("Hot Poppin Cheeto Rockin");
		Meal meal2 = new Meal("Quick Beans n Tea");

		addStepsToRecipe(recipe1, step1, step2, step3);
		addStepsToRecipe(recipe2, cheetoStep1);
		addStepsToRecipe(recipe3, step4, step5, step6, step7, step8, step9, step10, step11, step12, step13, step14,
				step15);
		addStepsToRecipe(recipe4, step16, step17, step18, step19, step20, step21);

		addIngredientsToRecipe(recipe1, farfalle, popRocks, hotDog);
		recipe1.addIngredientToList(farfalle, "1 cup");
		recipe1.addIngredientToList(popRocks, "2 packets");
		recipe1.addIngredientToList(hotDog, "10");
		recipe1.showIngredientsList();
		recipeRepo.save(recipe1);
		addIngredientsToRecipe(recipe2, cheeto);
		recipe2.addIngredientToList(cheeto, "1");
		recipeRepo.save(recipe2);
		addIngredientsToRecipe(recipe3, navyBean, pintoBean, lightKidneyBean, darkKidneyBean, garbanzoBean, butterBean,
				bakedBean, favaBean, cannelliniBean, flageoletBean);
		recipe3.addIngredientToList(navyBean, "1");
		recipe3.addIngredientToList(pintoBean, "1");
		recipe3.addIngredientToList(lightKidneyBean, "1");
		recipe3.addIngredientToList(darkKidneyBean, "1");
		recipe3.addIngredientToList(garbanzoBean, "1");
		recipe3.addIngredientToList(butterBean, "1");
		recipe3.addIngredientToList(bakedBean, "1");
		recipe3.addIngredientToList(favaBean, "1");
		recipe3.addIngredientToList(cannelliniBean, "1");
		recipe3.addIngredientToList(flageoletBean, "1");
		recipeRepo.save(recipe3);
		addIngredientsToRecipe(recipe4, hotDog, milk, tapiocaBall);
		recipe4.addIngredientToList(hotDog, "3");
		recipe4.addIngredientToList(milk, "1 gulp");
		recipe4.addIngredientToList(tapiocaBall, "1 Scoop");
		recipeRepo.save(recipe4);

		addRecipesToMeal(meal1, recipe1, recipe2);
		addRecipesToMeal(meal2, recipe3, recipe4);

	}

}
