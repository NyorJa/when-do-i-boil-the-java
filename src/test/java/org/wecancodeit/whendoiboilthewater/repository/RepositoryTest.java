package org.wecancodeit.whendoiboilthewater.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.whendoiboilthewater.repositories.IngredientRepository;
import org.wecancodeit.whendoiboilthewater.repositories.MealRepository;
import org.wecancodeit.whendoiboilthewater.repositories.RecipeRepository;
import org.wecancodeit.whendoiboilthewater.repositories.StepRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private StepRepository stepRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void testRepo() {
        stepRepository.findAll();
        recipeRepository.findAll();
        mealRepository.findAll();
        ingredientRepository.findAll();
    }
}
