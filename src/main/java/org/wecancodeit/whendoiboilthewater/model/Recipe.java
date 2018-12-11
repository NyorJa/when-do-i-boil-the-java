package org.wecancodeit.whendoiboilthewater.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	private int servingSize;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	private Long length;

	@OneToMany(mappedBy = "recipe")
	private List<Step> steps = new ArrayList<Step>();
	@ManyToMany
	private Collection<Ingredient> ingredients = new HashSet<Ingredient>();
	@JsonIgnore
	@ManyToMany
	private Collection<Meal> meals = new HashSet<Meal>();

	public Recipe() {
	}

	public Recipe(String name, int servingSize, String description) {
		this.name = name;
		this.servingSize = servingSize;
		this.description = description;
		this.length = calculateLength();
	}

	public Recipe(String name, int servingSize) {
		this.name = name;
		this.servingSize = servingSize;
		this.description = "A collection of food items intended for use in your mouth.";
	}

	public Recipe(String name, String description) {
		this.name = name;
		this.description = description;
		this.servingSize = 2147483647;
	}

	public Recipe(String name) {
		this.name = name;
		this.description = "A collection of food items intended for use in your mouth";
		this.servingSize = 2147483647;
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
