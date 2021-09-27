package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseService {

    private final CourseRepository courseRepository;
    private final String NON_EXISTING_COURSE_MESSAGE = "The course cannot be updated because, does not exists!";

    public UpdateCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course update(Long id, Course newCourse) {
        validateExistingCourse(id);
        return courseRepository.update(id, newCourse);
    }

    private void validateExistingCourse(Long id) {
        if (courseRepository.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}