package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseService;
import org.springframework.stereotype.Service;

@Service
public class deleteCoursesService {

    private final CourseService courseService;
    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";

    public deleteCoursesService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void delete(Course course) {
        validateExistingCourse(course);
        courseService.delete(course);
    }

    private void validateExistingCourse(Course course) {
        if (courseService.findById(course.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}
