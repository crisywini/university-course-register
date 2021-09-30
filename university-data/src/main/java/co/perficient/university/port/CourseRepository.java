package co.perficient.university.port;

import co.perficient.university.model.Course;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, CourseDto, Long> {

    CourseSubjectDto addCourseSubject(Long courseId, CourseSubject);
}
