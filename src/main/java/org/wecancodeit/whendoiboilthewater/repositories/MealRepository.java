package org.wecancodeit.whendoiboilthewater.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.whendoiboilthewater.models.Meal;
import org.wecancodeit.whendoiboilthewater.models.Recipe;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

	public Collection<Meal> findByRecipes(Recipe recipe);

}
