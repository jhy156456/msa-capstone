package hwmsacapstone.infra;

import hwmsacapstone.domain.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ScheduleViewRepository
    extends CrudRepository<ScheduleView, Long> {
    // keep

}
