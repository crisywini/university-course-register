package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayScheduleJPARepository extends JpaRepository<DaySchedule, Long> {
}
