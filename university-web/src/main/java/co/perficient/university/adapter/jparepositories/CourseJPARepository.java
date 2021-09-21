package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJPARepository extends JpaRepository<Course, Long> {
}
