package org.wecancodeit.whendoiboilthewater.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.whendoiboilthewater.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
