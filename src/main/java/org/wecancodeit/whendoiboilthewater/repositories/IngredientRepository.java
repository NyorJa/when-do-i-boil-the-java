package org.wecancodeit.whendoiboilthewater.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.whendoiboilthewater.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

	public Ingredient findByNameAndQuantityIgnoreCase(String name, String quantity);

}
