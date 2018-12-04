package org.wecancodeit.whendoiboilthewater.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.whendoiboilthewater.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
