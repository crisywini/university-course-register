package co.perficient.university.port;

import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, CourseDto, Long> {

    Optional<CourseSubjectDto> addCourseSubject(Long courseId, CourseSubject courseSubject);
    List<CourseDto> findByName(String name);
    List<CourseDto> findByUser(String userId);
    List<CourseDto> findByFaculty(Faculty faculty);
    List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel);
    List<CourseDto> findByModality(Modality modality);
}
