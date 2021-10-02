package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.FindCourseSubjectByMethodologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseSubjectByMethodologyApplicationService {
    private final FindCourseSubjectByMethodologyService findCourseSubjectByMethodologyService;

    public FindCourseSubjectByMethodologyApplicationService(FindCourseSubjectByMethodologyService findCourseSubjectByMethodologyService) {
        this.findCourseSubjectByMethodologyService = findCourseSubjectByMethodologyService;
    }

    public List<CourseSubjectDto> run(Methodology methodology) {
        return this.findCourseSubjectByMethodologyService.findByMethodology(methodology);
    }
}
