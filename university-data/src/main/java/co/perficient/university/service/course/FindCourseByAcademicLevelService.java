package co.perficient.university.service.course;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByAcademicLevelService {
    private final CourseRepository courseRepository;

    public FindCourseByAcademicLevelService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel) {
        return courseRepository.findByAcademicLevel(academicLevel);
    }

}
