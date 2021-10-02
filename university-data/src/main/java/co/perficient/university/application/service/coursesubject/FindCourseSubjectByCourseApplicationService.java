package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.FindCourseSubjectByCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseSubjectByCourseApplicationService {
    private final FindCourseSubjectByCourseService findCourseSubjectByCourseService;

    public FindCourseSubjectByCourseApplicationService(FindCourseSubjectByCourseService findCourseSubjectByCourseService) {
        this.findCourseSubjectByCourseService = findCourseSubjectByCourseService;
    }

    public List<CourseSubjectDto> run(Long courseId) {
        return findCourseSubjectByCourseService.findByCourse(courseId);
    }

}
