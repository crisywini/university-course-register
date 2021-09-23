package co.perficient.university.port;

import co.perficient.university.model.Schedule;

import java.util.Set;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    Set<Schedule> findAll();
}
