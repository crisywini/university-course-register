package co.perficient.university.service.course;

import co.perficient.university.port.CourseService;
import org.springframework.stereotype.Service;

@Service
public class deleteCourseByIdService {

    private final CourseService courseService;
    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";

    public deleteCourseByIdService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void deleteById(Long id) {
        validateExistingCourse(id);
        courseService.deleteById(id);
    }

    private void validateExistingCourse(Long id) {
        if (courseService.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}
