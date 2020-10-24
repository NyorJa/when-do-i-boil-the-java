package org.wecancodeit.whendoiboilthewater.controllers;

import org.wecancodeit.whendoiboilthewater.services.MealService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;
import org.wecancodeit.whendoiboilthewater.repositories.RecipeRepository;

import java.util.Collection;

@CrossOrigin
@RestController
public class MealController {

    @Autowired MealRepository mealRepo;
    @Autowired RecipeRepository recipeRepo;
    @Autowired MealService mealService;

    public MealController(){
    }

    @GetMapping("/api/meals")
    public Collection<Meal> showMeals() {
        return (Collection<Meal>) mealRepo.findAll();
    }

    @GetMapping("/api/meals/{mealId}")
    public Meal showMeal(@PathVariable(value = "mealId") Long mealId) {
        return mealRepo.findById(mealId).get();
    }

    @GetMapping("/api/meals/{mealId}/recipes")
    public Collection<Recipe> showMealRecipes(@PathVariable(value = "mealId") Long mealId) {
        return mealRepo.findById(mealId).get().getRecipes();
    }

    @GetMapping("/api/meals/{mealId}/recipes/{recipeId}")
    public Recipe showMealRecipe(@PathVariable(value = "mealId") Long mealId,
                                 @PathVariable(value = "recipeId") Long recipeId) {
        return recipeRepo.findById(recipeId).get();
    }

    @PostMapping("/api/meals/add")
    public Meal createMeal(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        String mealName = json.getString("mealName");
        Meal meal = mealService.addNewMeal(mealName);
        return meal;
    }

    @PostMapping("/api/meals/remove")
    public Collection<Meal> removeMeal(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        Long mealId = json.getLong("mealId");
        mealRepo.delete(mealRepo.findById(mealId).get());
        return (Collection<Meal>) mealRepo.findAll();
    }

    @PostMapping("/api/meals/addRecipe")
    public Meal addRecipeToMeal(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        Long mealId = json.getLong("mealId");
        Long recipeId = json.getLong("recipeId");
        Meal meal = mealRepo.findById(mealId).get();
        Recipe recipe = recipeRepo.findById(recipeId).get();
        meal.addRecipe(recipe);
        mealRepo.save(meal);
        return meal;
    }

    @PostMapping("api/meals/updateName")
    public Meal updateMealName(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        String mealName = json.getString("mealName");
        Long mealId = json.getLong("mealId");
        Meal meal = mealRepo.findById(mealId).get();
        meal.setName(mealName);
        mealRepo.save(meal);
        return meal;
    }

    @PostMapping("/api/meal/removeRecipe")
    public Meal removeRecipeFromMeal(@RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        Long mealId = json.getLong("mealId");
        Long recipeId = json.getLong("recipeId");
        Recipe recipe = recipeRepo.findById(recipeId).get();
        Meal meal = mealRepo.findById(mealId).get();
        meal.removeRecipe(recipe);
        mealRepo.save(meal);
        return meal;
    }
}
