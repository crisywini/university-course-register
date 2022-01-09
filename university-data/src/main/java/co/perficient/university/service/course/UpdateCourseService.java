package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseService {

    private final CourseRepository courseRepository;

    private static final String NON_EXISTING_COURSE_MESSAGE = "The course cannot be updated because, does not exists!";

    public UpdateCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<CourseDto> update(Long id, Course newCourse) {
        return courseRepository.update(getIdIfCourseIsPresent(id), newCourse);
    }

    private Long getIdIfCourseIsPresent(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_COURSE_MESSAGE))
                .getId();
    }
}
