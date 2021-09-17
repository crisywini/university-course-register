package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectService;
import org.springframework.stereotype.Service;

@Service
public class deleteCourseSubjectService {

    private final CourseSubjectService courseSubjectService;
    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject does not exists!";

    public deleteCourseSubjectService(CourseSubjectService courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public void delete(CourseSubject courseSubject) {
        validateExistingCourse(courseSubject);
        courseSubjectService.delete(courseSubject);
    }

    private void validateExistingCourse(CourseSubject courseSubject) {
        if (courseSubjectService.findById(courseSubject.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
