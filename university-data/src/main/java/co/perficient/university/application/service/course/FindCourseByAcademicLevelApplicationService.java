package co.perficient.university.application.service.course;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByAcademicLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByAcademicLevelApplicationService {
    private final FindCourseByAcademicLevelService findCourseByAcademicLevelService;

    public FindCourseByAcademicLevelApplicationService(FindCourseByAcademicLevelService findCourseByAcademicLevelService) {
        this.findCourseByAcademicLevelService = findCourseByAcademicLevelService;
    }

    public List<CourseDto> run(AcademicLevel academicLevel) {
        return findCourseByAcademicLevelService.findByAcademicLevel(academicLevel);
    }
}
