package org.wecancodeit.whendoiboilthewater.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "/api/recipes";

    @Test
    public void testShowRecipes() throws Exception {
        mockMvc.perform(get(PATH))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testShowRecipe() throws Exception {
        mockMvc.perform(get(PATH + "/{recipeId}", 3))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testShowRecipeSteps() throws Exception {
        mockMvc.perform(get(PATH + "/{recipeId}/steps", 3))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testShowRecipeIngredients() throws Exception {
        mockMvc.perform(get(PATH + "/{recipeId}/ingredients", 3))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateRecipe() throws Exception {
        mockMvc.perform(post(PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"recipeName\":\"adobo sa gata\",\"servingSize\":1,\"recipeDescription\":\"filipino dish\",\"length\":1,\"stepsArray\":[{\"secondsToEnd\":1,\"stepDescription\":\"desc-1\"}],\"ingredientsArray\":[{\"ingredientsName\":\"MSG-1\",\"ingredientsQty\":\"1 kg\"}]}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveRecipe() throws Exception {
        mockMvc.perform(post(PATH + "/remove")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"recipeId\": 12}"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
