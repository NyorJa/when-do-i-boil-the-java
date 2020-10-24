package org.wecancodeit.whendoiboilthewater.controllers;

import org.wecancodeit.whendoiboilthewater.models.Ingredient;
import org.wecancodeit.whendoiboilthewater.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepo;

    public IngredientController(){
    }

    @GetMapping("/api/ingredients")
    public Collection<Ingredient> showIngredients() {
        return (Collection<Ingredient>) ingredientRepo.findAll();
    }

    @GetMapping("/api/ingredients/{ingredientId}")
    public Ingredient showIngredient(@PathVariable(value = "ingredientId") Long ingredientId) {
        return ingredientRepo.findById(ingredientId).get();
    }

}
