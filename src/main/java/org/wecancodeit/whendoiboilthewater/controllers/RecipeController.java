package org.wecancodeit.whendoiboilthewater.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.wecancodeit.whendoiboilthewater.repositories.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repositories.StepRepository;
import org.wecancodeit.whendoiboilthewater.services.RecipeService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.whendoiboilthewater.models.Ingredient;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.models.Step;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;
import org.wecancodeit.whendoiboilthewater.repositories.RecipeRepository;

import java.util.Collection;
import java.util.Collections;

@CrossOrigin
@RestController
public class RecipeController {

    @Autowired RecipeRepository recipeRepo;
    @Autowired
    RecipeService recipeService;
    @Autowired
    IngredientRepository ingredientRepo;
    @Autowired
    StepRepository stepRepo;
    @Autowired MealRepository mealRepo;

    public RecipeController(){
    }

    @GetMapping("/api/recipes")
    public Collection<Recipe> showRecipes() {
        return (Collection<Recipe>) recipeRepo.findAll();
    }

    @GetMapping("/api/recipes/{recipeId}")
    public Recipe showRecipe(@PathVariable(value = "recipeId") Long recipeId) {
        return recipeRepo.findById(recipeId).get();
    }

    @GetMapping("/api/recipes/{recipeId}/steps")
    public Collection<Step> showRecipeSteps(@PathVariable(value = "recipeId") Long recipeId) {
        return recipeRepo.findById(recipeId).get().getSteps();
    }

    @GetMapping("/api/recipes/{recipeId}/ingredients")
    public Collection<Ingredient> showRecipeIngredient(@PathVariable(value = "recipeId") Long recipeId) {
        return recipeRepo.findById(recipeId).get().getIngredients();
    }

    @PostMapping("/api/recipes/add")
    public Recipe createRecipe(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        String recipeName = json.getString("recipeName");
        int servingSize = json.getInt("servingSize");
        String recipeDescription = json.getString("recipeDescription");
        JSONArray ingredientsArray = json.getJSONArray("ingredientsArray");
        JSONArray stepsArray = json.getJSONArray("stepsArray");
        Recipe recipe = recipeService.addNewRecipe(recipeName, servingSize, recipeDescription);
        for (int i = 0; i < ingredientsArray.length(); i++) {
            String ingredientName = ingredientsArray.getJSONObject(i).getString("ingredientsName");
            String ingredientQty = ingredientsArray.getJSONObject(i).getString("ingredientsQty");
            Ingredient enteredIngredient = ingredientRepo.findByNameAndQuantityIgnoreCase(ingredientName,
                    ingredientQty);
            if (enteredIngredient == null) {
                Ingredient ingredient = recipeService.addNewIngredient(ingredientName, ingredientQty);
                recipeService.addRecipeIngredient(ingredient, recipe);
                ingredientRepo.save(ingredient);
            } else {
                recipeService.addRecipeIngredient(enteredIngredient, recipe);
                ingredientRepo.save(enteredIngredient);
            }
        }
        for (int i = 0; i < stepsArray.length(); i++) {
            Long secondsToEnd = stepsArray.getJSONObject(i).getLong("secondsToEnd");
            String stepDescription = stepsArray.getJSONObject(i).getString("stepDescription");
            Step step = recipeService.addNewStep(secondsToEnd, stepDescription);
            recipeService.addRecipeStep(step, recipe);
            stepRepo.save(step);
        }
        recipeRepo.save(recipe);
        return recipe;
    }

    @PostMapping("/api/recipes/remove")
    public Collection<Recipe> removeRecipe(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        Long recipeId = json.getLong("recipeId");
        if (!recipeRepo.findById(recipeId).isPresent()) {
            return Collections.emptyList();
        }
        Recipe recipe = recipeRepo.findById(recipeId).get();
        Collection<Meal> meals = mealRepo.findByRecipes(recipe);
        Collection<Step> steps = recipe.getSteps();

        if (!CollectionUtils.isEmpty(meals)) {
            for (Meal meal : meals) {
                meal.removeRecipe(recipe);
                mealRepo.save(meal);
            }
        }
        if (!CollectionUtils.isEmpty(steps)) {
            for (Step step : steps) {
                stepRepo.delete(step);
            }
        }
        recipeRepo.delete(recipe);
        return (Collection<Recipe>) recipeRepo.findAll();

    }
}
