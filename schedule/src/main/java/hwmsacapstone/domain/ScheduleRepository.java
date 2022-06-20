package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "schedules", path = "schedules")
public interface ScheduleRepository
    extends PagingAndSortingRepository<Schedule, Long> {}
