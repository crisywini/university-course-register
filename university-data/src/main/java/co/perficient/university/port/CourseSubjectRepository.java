package co.perficient.university.port;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSubjectRepository extends CrudRepository<CourseSubject, CourseSubjectDto, Long> {

}
