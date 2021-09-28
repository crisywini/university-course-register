package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.SaveCourseSubjectService;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseSubjectApplicationService {
    private final SaveCourseSubjectService courseSubjectService;

    public SaveCourseSubjectApplicationService(SaveCourseSubjectService courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public CourseSubjectDto run(CourseSubject courseSubject) {
        return courseSubjectService.save(courseSubject);
    }
}
