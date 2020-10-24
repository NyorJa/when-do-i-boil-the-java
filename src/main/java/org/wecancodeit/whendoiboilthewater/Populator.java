//package org.wecancodeit.whendoiboilthewater;
//
//import org.wecancodeit.whendoiboilthewater.models.Ingredient;
//import org.wecancodeit.whendoiboilthewater.models.Meal;
//import org.wecancodeit.whendoiboilthewater.models.Recipe;
//import org.wecancodeit.whendoiboilthewater.models.Step;
//import org.wecancodeit.whendoiboilthewater.services.RecipeService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Populator extends RecipeService implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Ingredient farfalle = addNewIngredient("farfalle");
//		Ingredient popRocks = addNewIngredient("Pop Rocks");
//		Ingredient hotDog = addNewIngredient("Hot Dogs");
//		Ingredient hotDog2 = addNewIngredient("Hot Dogs", "1 desk");
//		Ingredient cheeto = addNewIngredient("cheeto");
//		Ingredient navyBean = addNewIngredient("Navy Bean", "1");
//		Ingredient pintoBean = addNewIngredient("Pinto Bean", "1");
//		Ingredient lightKidneyBean = addNewIngredient("Light Kidney Bean", "1");
//		Ingredient darkKidneyBean = addNewIngredient("Dark Kidney Bean", "1");
//		Ingredient garbanzoBean = addNewIngredient("Garbanzo Bean", "1");
//		Ingredient butterBean = addNewIngredient("Butter Bean", "1");
//		Ingredient bakedBean = addNewIngredient("Baked Bean", "1");
//		Ingredient favaBean = addNewIngredient("Fava Bean", "1");
//		Ingredient coffeeBean = addNewIngredient("Coffee Bean", "1");
//		Ingredient flageoletBean = addNewIngredient("Flageolet Bean", "1");
//		Ingredient milk = addNewIngredient("Milk", "1 gulp");
//		Ingredient tapiocaBall = addNewIngredient("Tapioca Balls", "1 metric unit");
//
//		Step step1 = addNewStep(15L, "boil the pop rocks");
//		Step step2 = addNewStep(10L, "dice the hot dogs");
//		Step step3 = addNewStep(5L, "stir in the hot dogs");
//		Step cheetoStep1 = addNewStep(66L, "Fry Cheeto");
//		Step step4 = addNewStep(65L, "boil all them beans hard AF");
//		Step step5 = addNewStep(60L, "drain all them beans");
//		Step step6 = addNewStep(55L, "add the Navy Bean to the bowl");
//		Step step7 = addNewStep(50L, "add the Pinto Bean to the bowl");
//		Step step8 = addNewStep(45L, "add the Light Kidney Bean to the bowl");
//		Step step9 = addNewStep(40L, "add the Dark Kidney Bean to the bowl");
//		Step step10 = addNewStep(35L, "add the Garbanzo Bean to the bowl");
//		Step step11 = addNewStep(30L, "add the Butter Bean to the bowl");
//		Step step12 = addNewStep(25L, "add the Baked Bean to the bowl");
//		Step step13 = addNewStep(20L, "add the Fava Bean to the bowl");
//		Step step14 = addNewStep(15L, "add the Coffee Bean to the bowl");
//		Step step15 = addNewStep(10L, "add the FlageoletBean to the bowl");
//		Step step16 = addNewStep(67L, "steep the hotdogs in nearly boiling water");
//		Step step17 = addNewStep(42L, "remove hot dogs from water");
//		Step step18 = addNewStep(37L, "add milk to hot dog tea");
//		Step step19 = addNewStep(32L, "whisk together hot dog tea and milk");
//		Step step20 = addNewStep(27L, "set aside hot dog milk tea");
//		Step step21 = addNewStep(7L, "add tapioca balls to hot dog milk tea");
//
//		Recipe recipe1 = addNewRecipe("Hot Pop Rock Dog Stew", 12, "A frothy, exciting treat for a cold summer night.");
//		Recipe recipe2 = addNewRecipe("Single Fried Cheeto", 4, "A delicacy.");
//		Recipe recipe3 = addNewRecipe("Quick 10-Bean Salad", 10, "Ten High Quality Beans for Ten High Quality Folks");
//		Recipe recipe4 = addNewRecipe("Hot Dog Milk Tea Boba", 10,
//				"Fancy bubble tea featuring your favorite of conglomerated meat products, the Hot Dog!");
//
//		Meal meal1 = addNewMeal("Hot Poppin Cheeto Rockin");
//		Meal meal2 = addNewMeal("Quick Beans n Tea");
//
//		addStepsToRecipe(recipe1, step1, step2, step3);
//		addStepsToRecipe(recipe2, cheetoStep1);
//		addStepsToRecipe(recipe3, step4, step5, step6, step7, step8, step9, step10, step11, step12, step13, step14,
//				step15);
//		addStepsToRecipe(recipe4, step16, step17, step18, step19, step20, step21);
//
//		addIngredientsToRecipe(recipe1, farfalle, popRocks, hotDog);
//
//		addIngredientsToRecipe(recipe2, cheeto);
//
//		addIngredientsToRecipe(recipe3, navyBean, pintoBean, lightKidneyBean, darkKidneyBean, garbanzoBean, butterBean,
//				bakedBean, favaBean, coffeeBean, flageoletBean);
//
//		addIngredientsToRecipe(recipe4, hotDog2, milk, tapiocaBall);
//
//		addRecipesToMeal(meal1, recipe1, recipe2);
//		addRecipesToMeal(meal2, recipe3, recipe4);
//
//	}
//
//}
