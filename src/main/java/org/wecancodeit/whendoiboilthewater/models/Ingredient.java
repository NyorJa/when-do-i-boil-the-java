package org.wecancodeit.whendoiboilthewater.models;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	private String quantity;
	@JsonIgnore
	@ManyToMany(mappedBy = "ingredients")
	private Collection<Recipe> recipes = new HashSet<Recipe>();

	public Ingredient() {
	}

	public Ingredient(String name) {
		this.name = name;
		this.quantity = "some";
	}

	public Ingredient(String name, String quantity) {
		this.name = name;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}

	public Collection<Recipe> getRecipes() {
		return recipes;
	}

	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
	}

}
