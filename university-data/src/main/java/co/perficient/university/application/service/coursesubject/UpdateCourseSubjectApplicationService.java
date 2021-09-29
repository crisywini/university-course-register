package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.UpdateCourseSubjectService;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseSubjectApplicationService {
    private final UpdateCourseSubjectService updateCourseSubjectService;

    public UpdateCourseSubjectApplicationService(UpdateCourseSubjectService updateCourseSubjectService) {
        this.updateCourseSubjectService = updateCourseSubjectService;
    }

    public CourseSubjectDto run(Long id, CourseSubject newCourseSubject) {
        return updateCourseSubjectService.update(id, newCourseSubject);
    }
}
