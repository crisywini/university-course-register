package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveCourseSubjectService {

    private final CourseSubjectRepository courseSubjectService;
    private final CourseRepository courseRepository;
    private static final String COURSE_SUBJECT_REPEATED_MESSAGE = "The course subject already exists!";
    private static final String COURSE_NON_EXISTING_MESSAGE = "The course does not exists!";

    public Optional<CourseSubject> save(CourseSubject courseSubject) {
        validateNonRepeated(courseSubject);
        validateExistingCourse(courseSubject.getCourse());
        return courseSubjectService.save(courseSubject);
    }

    private void validateExistingCourse(Course course) {
        Course courseNonNull = Objects.requireNonNull(course);
        if (courseRepository.findById(courseNonNull.getId()).isEmpty()) {
            throw new NullEntityException(COURSE_NON_EXISTING_MESSAGE);
        }
    }

    private void validateNonRepeated(CourseSubject courseSubject) {
        Long id = Objects.requireNonNull(courseSubject.getId());
        if ( courseSubjectService.findById(id).isPresent()) {
            throw new RepeatedEntityException(COURSE_SUBJECT_REPEATED_MESSAGE);
        }
    }

}
