package org.wecancodeit.whendoiboilthewater.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.whendoiboilthewater.model.Meal;
import org.wecancodeit.whendoiboilthewater.model.Recipe;

public interface MealRepository extends CrudRepository<Meal, Long> {

	public Collection<Meal> findByRecipes(Recipe recipe);

}
