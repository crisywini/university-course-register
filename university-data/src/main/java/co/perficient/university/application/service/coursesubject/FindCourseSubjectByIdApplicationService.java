package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.service.coursesubject.FindCourseSubjectByIdService;
import org.springframework.stereotype.Service;

@Service
public class FindCourseSubjectByIdApplicationService {
    private final FindCourseSubjectByIdService findCourseSubjectByIdService;

    public FindCourseSubjectByIdApplicationService(FindCourseSubjectByIdService findCourseSubjectByIdService) {
        this.findCourseSubjectByIdService = findCourseSubjectByIdService;
    }

    public CourseSubject run(Long id) {
        return findCourseSubjectByIdService.findById(id);
    }
}