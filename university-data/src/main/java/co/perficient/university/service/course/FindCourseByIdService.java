package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseService;
import org.springframework.stereotype.Service;

@Service
public class FindCourseByIdService {

    private final CourseService courseService;

    public FindCourseByIdService(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course findById(Long id) {
        return courseService.findById(id);
    }
}
