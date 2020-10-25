package org.wecancodeit.whendoiboilthewater.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowIngredients() throws Exception {
        mockMvc.perform(get("/api/ingredients"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testShowIngredient() throws Exception {
        mockMvc.perform(get("/api/ingredients/{ingredientId}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
