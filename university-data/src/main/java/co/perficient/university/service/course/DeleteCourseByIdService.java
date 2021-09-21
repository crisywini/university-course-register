package co.perficient.university.service.course;

import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseByIdService {

    private final CourseRepository courseRepository;
    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";

    public DeleteCourseByIdService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void deleteById(Long id) {
        validateExisting(id);
        courseRepository.deleteById(id);
    }

    private void validateExisting(Long id) {
        if (courseRepository.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}
