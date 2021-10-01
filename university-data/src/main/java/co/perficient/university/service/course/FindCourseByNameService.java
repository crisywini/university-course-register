package co.perficient.university.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByNameService {
    private final CourseRepository courseRepository;

    public FindCourseByNameService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findByName(String name) {
        return courseRepository.findByName(name);
    }
}


