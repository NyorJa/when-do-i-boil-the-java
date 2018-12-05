package org.wecancodeit.whendoiboilthewater.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	private int servingSize;
	private String description;
	private Long length;
	@OneToMany(mappedBy = "recipe")
	private List<Step> steps = new ArrayList<Step>();
	@JsonIgnore
	@ManyToMany
	private Collection<Ingredient> ingredients = new HashSet<Ingredient>();
	@JsonIgnore
	@ManyToMany
	private Collection<Meal> meals = new HashSet<Meal>();
	private HashMap<Ingredient, String> ingredientsList = new HashMap<>();

	public Recipe() {
	}

	public Recipe(String name, int servingSize, String description) {
		this.name = name;
		this.servingSize = servingSize;
		this.description = description;
		this.length = calculateLength();
	}

	public Long getId() {
		return id;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public Collection<Ingredient> getIngredients() {
		return ingredients;
	}

	public Long getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	public int getServingSize() {
		return servingSize;
	}

	public Collection<Meal> getMeals() {
		return meals;
	}

	public String getDescription() {
		return description;
	}

	// will we ever use this?
	public void addStep(String description, Long secBeforeEnd) {
		steps.add(new Step(secBeforeEnd, description));
		length = calculateLength();
	}

	public void addStep(Step step) {
		steps.add(step);
		length = calculateLength();
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public void addIngredientToList(Ingredient ingredientToAdd, String ingredientQuantity) {
		ingredientsList.put(ingredientToAdd, ingredientQuantity);
	}

	public String showIngredientsList() {
		String ingredientsListEntries = "";
		for (Ingredient key : ingredientsList.keySet()) {
			String ingredientsListEntry;
			ingredientsListEntry = ingredientsList.get(key) + " " + key.getName() + "\n";
			ingredientsListEntries += ingredientsListEntry;
		}
		System.out.println(ingredientsListEntries);
		return ingredientsListEntries;
	}

	public Long calculateLength() {
		Long longestStepTime = 0L;
		for (Step step : steps) {
			if (step.getSecBeforeEnd() > longestStepTime) {
				longestStepTime = step.getSecBeforeEnd();
			}
		}
		return longestStepTime;
	}

}
