package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleJPARepository extends JpaRepository<Schedule, Long> {
}
