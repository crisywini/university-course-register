package co.perficient.university.service.course;

import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class SaveCourseService {

    private final CourseRepository courseRepository;
    private static final String COURSE_REPEATED_MESSAGE = "The course already exists!";


    public Optional<CourseDto> save(Course course) {
        validateNonRepeated(course);
        return courseRepository.save(course);
    }

    private void validateNonRepeated(Course course) {
        Objects.requireNonNull(course.getId());
        if (courseRepository.findById(course.getId()).isPresent()) {
            throw new RepeatedEntityException(COURSE_REPEATED_MESSAGE);
        }
    }

}
