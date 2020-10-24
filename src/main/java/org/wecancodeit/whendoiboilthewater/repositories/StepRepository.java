package org.wecancodeit.whendoiboilthewater.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.whendoiboilthewater.models.Step;

@Repository
public interface StepRepository extends CrudRepository<Step, Long> {

	Step findBySecBeforeEndAndDescriptionIgnoreCase(Long secondsToEnd, String stepDescription);

}
