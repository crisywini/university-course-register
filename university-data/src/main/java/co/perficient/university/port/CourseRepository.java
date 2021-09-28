package co.perficient.university.port;

import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, CourseDto, Long> {
}
