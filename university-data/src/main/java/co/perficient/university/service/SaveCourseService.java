package co.perficient.university.service;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseService;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseService {

    private final CourseService courseService;
    private static final String COURSE_REPEATED_MESSAGE = "The course already exists!";

    public SaveCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course save(Course course) {
        validateNonRepeated(course);
        return courseService.save(course);
    }

    private void validateNonRepeated(Course course) {
        if (courseService.findById(course.getId()) != null) {
            throw new RuntimeException(COURSE_REPEATED_MESSAGE);
        }
    }

}
