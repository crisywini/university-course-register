package co.perficient.university.service.course;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByAcademicLevelService {
    private final CourseRepository courseRepository;
    private static final String ACADEMIC_LEVEL_NOT_FOUND_MESSAGE = "The academic level is not correct!";

    public FindCourseByAcademicLevelService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel) {
        if (academicLevel.equals(AcademicLevel.n)) {
            throw new ParamNotFoundException(ACADEMIC_LEVEL_NOT_FOUND_MESSAGE);
        }
        return courseRepository.findByAcademicLevel(academicLevel);
    }

}
