package co.perficient.university.service.course;

import co.perficient.university.model.Faculty;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByFacultyService {

    private final CourseRepository courseRepository;

    public FindCourseByFacultyService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findByFaculty(Faculty faculty) {
        return courseRepository.findByFaculty(faculty);
    }
}
