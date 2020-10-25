package org.wecancodeit.whendoiboilthewater.config;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.wecancodeit.whendoiboilthewater.models.Ingredient;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;
import org.wecancodeit.whendoiboilthewater.models.Step;
import org.wecancodeit.whendoiboilthewater.repositories.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;
import org.wecancodeit.whendoiboilthewater.repositories.RecipeRepository;
import org.wecancodeit.whendoiboilthewater.repositories.StepRepository;

import javax.annotation.PostConstruct;

@Profile("test")
@Configuration
public class H2InitConfig {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private StepRepository stepRepository;

    @PostConstruct
    public void init() {
        stepRepository.deleteAll();
        mealRepository.deleteAll();
        ingredientRepository.deleteAll();
        stepRepository.deleteAll();


        Step step = new Step(1L, "example step");
        stepRepository.save(step);

        Ingredient ingredient = new Ingredient("MSG", "1 kg");
        ingredientRepository.save(ingredient);

        Recipe recipe = new Recipe("Adobo", 1, "filipino dish");
        recipe.addIngredient(ingredient);


        Recipe recipe2 = new Recipe("Bulalo", 1, "filipino dish");
        recipe2.addIngredient(ingredient);

        Recipe recipe3 = new Recipe("Soup-5", 1, "filipino dish");
//        recipe3.addIngredient(ingredient);

        recipeRepository.saveAll(Lists.newArrayList(recipe, recipe2, recipe3));


        Meal meal = new Meal();
        meal.setName("Budget meal");
        meal.addRecipe(recipe);
        meal.addRecipe(recipe3);


        Meal meal2 = new Meal();
        meal2.setName("Ala Carte");
        meal2.addRecipe(recipe2);

        Meal meal3 = new Meal("Bolshevik");
        meal3.addRecipe(recipe);

        Meal meal4 = new Meal("Gulag");
        meal4.addRecipe(recipe2);

        Meal meal5 = new Meal("Classmates");
        meal5.addRecipe(recipe2);

        mealRepository.saveAll(Lists.newArrayList(meal, meal2, meal3, meal4, meal5));

    }
}
