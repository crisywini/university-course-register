package co.perficient.university.port;

import co.perficient.university.model.CourseSubject;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseSubjectRepository extends CrudRepository<CourseSubject, Long> {
    Set<CourseSubject> findAll();
}
