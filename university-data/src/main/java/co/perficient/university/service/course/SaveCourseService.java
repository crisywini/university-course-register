package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseService {

    private final CourseRepository courseRepository;
    private static final String COURSE_REPEATED_MESSAGE = "The course already exists!";

    public SaveCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {
        validateNonRepeated(course);
        return courseRepository.save(course);
    }

    private void validateNonRepeated(Course course) {
        if (courseRepository.findById(course.getId()) != null) {
            throw new RuntimeException(COURSE_REPEATED_MESSAGE);
        }
    }

}
