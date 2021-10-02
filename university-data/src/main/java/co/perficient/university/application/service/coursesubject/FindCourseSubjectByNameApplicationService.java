package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.FindCourseSubjectByNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseSubjectByNameApplicationService {
    private final FindCourseSubjectByNameService findCourseSubjectByNameService;

    public FindCourseSubjectByNameApplicationService(FindCourseSubjectByNameService findCourseSubjectByNameService) {
        this.findCourseSubjectByNameService = findCourseSubjectByNameService;
    }

    public List<CourseSubjectDto> run(String name) {
        return findCourseSubjectByNameService.findByName(name);
    }
}
