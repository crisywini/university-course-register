package co.perficient.university.port;

import co.perficient.university.model.Course;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Set<Course> findAll();

}
