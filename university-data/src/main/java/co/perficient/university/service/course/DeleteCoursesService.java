package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCoursesService {

    private final CourseRepository courseRepository;
    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";


    public void delete(Course course) {
        validateExisting(course);
        courseRepository.delete(course);
    }

    private void validateExisting(Course course) {
        if (courseRepository.findById(course.getId()).isEmpty()) {
            throw new NullEntityException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}
