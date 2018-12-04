package org.wecancodeit.whendoiboilthewater.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {
	@GeneratedValue @Id private Long id;
	private String name;
	
	@ManyToMany
	private Collection<Recipe> recipes = new HashSet<Recipe>();
	
	public Ingredient() {}

	public Ingredient(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Recipe> getRecipes() {
		return recipes;
	}
	
	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
	}
	
	
}
