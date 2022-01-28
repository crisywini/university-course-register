package co.perficient.university.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FindCourseByIdService {

    private final CourseRepository courseRepository;

    public FindCourseByIdService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
}
