package co.perficient.university.port;

import co.perficient.university.model.DaySchedule;

import java.util.Set;

public interface DayScheduleRepository extends CrudRepository<DaySchedule, Long> {
    Set<DaySchedule> findAll();

    DaySchedule update(Long id, DaySchedule newEntity);
}
