package org.wecancodeit.whendoiboilthewater.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.whendoiboilthewater.model.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

}
