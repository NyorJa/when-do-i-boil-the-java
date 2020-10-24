package org.wecancodeit.whendoiboilthewater.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.whendoiboilthewater.models.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
