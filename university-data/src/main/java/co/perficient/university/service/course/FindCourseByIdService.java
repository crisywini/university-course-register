package co.perficient.university.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FindCourseByIdService {

    private final CourseRepository courseRepository;

    public FindCourseByIdService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<CourseDto> findById(Long id) {
        return courseRepository.findById(id);
    }
}
