package org.wecancodeit.whendoiboilthewater.controllers;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class MealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "/api/meals";

    @Test
    public void testGetMeals() throws Exception {
        mockMvc.perform(get(PATH)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMeal() throws Exception {
        mockMvc.perform(get(PATH + "/{mealId}", 5)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMealRecipes() throws Exception {
        mockMvc.perform(get(PATH + "/{mealId}/recipes", 5)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMealRecipe() throws Exception {
        mockMvc.perform(get(PATH + "/{mealId}/recipes/{recipeId}", 5, 4)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateMeal() throws Exception {
        mockMvc.perform(post(PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"mealName\":\"sisig\"}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveMeal() throws Exception {
        mockMvc.perform(post(PATH + "/remove")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"mealId\":7}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddRecipeToMeal() throws Exception {
        mockMvc.perform(post(PATH + "/addRecipe")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"recipeId\":4,\"mealId\":8}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMealName() throws Exception {
        mockMvc.perform(post(PATH + "/updateName")
                .content("{\"mealName\":\"Politburo\",\"mealId\":8}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveRecipeFromMeal() throws Exception {
        mockMvc.perform(post( "/api/meal/removeRecipe")
                .content("{\"recipeId\":4,\"mealId\":9}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
