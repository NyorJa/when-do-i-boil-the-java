package org.wecancodeit.whendoiboilthewater.services;

import org.springframework.stereotype.Service;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;

import javax.annotation.Resource;

@Service
public class MealService {

    @Resource
    MealRepository mealRepo;

    public MealService() {
        super();
    }

    public Meal addNewMeal(String mealName) {
        return mealRepo.save(new Meal(mealName));
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
