package org.wecancodeit.whendoiboilthewater.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Step {
	@Id @GeneratedValue private Long id;
	private Long secBeforeEnd;
	private String description;
	private boolean bypassNotification;
	@JsonIgnore @ManyToOne private Recipe recipe;


	public Step() {}

	public Step(Long secBeforeEnd, String description) {
		this.secBeforeEnd = secBeforeEnd;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public Long getSecBeforeEnd() {
		return secBeforeEnd;
	}

	public String getDescription() {
		return description;
	}

	public boolean isBypassNotification() {
		return bypassNotification;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public void addRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}