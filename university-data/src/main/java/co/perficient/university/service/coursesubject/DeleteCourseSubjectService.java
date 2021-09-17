package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectService;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseSubjectService {

    private final CourseSubjectService courseSubjectService;
    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject does not exists!";

    public DeleteCourseSubjectService(CourseSubjectService courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public void delete(CourseSubject courseSubject) {
        validateExisting(courseSubject);
        courseSubjectService.delete(courseSubject);
    }

    private void validateExisting(CourseSubject courseSubject) {
        if (courseSubjectService.findById(courseSubject.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
