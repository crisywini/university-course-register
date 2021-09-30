package co.perficient.university.port;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSubjectRepository extends CrudRepository<CourseSubject, CourseSubjectDto, Long> {

    List<CourseSubjectDto> findByName(String name);

    List<CourseSubjectDto> findByCourse(Long courseId);

    List<CourseSubjectDto> findByMethodology(Methodology methodology);
}
