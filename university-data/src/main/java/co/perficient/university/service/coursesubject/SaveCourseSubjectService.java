package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseSubjectService {

    private final CourseSubjectRepository courseSubjectService;
    private static final String COURSE_SUBJECT_REPEATED_MESSAGE = "The course subject already exists!";

    public SaveCourseSubjectService(CourseSubjectRepository courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public CourseSubject save(CourseSubject courseSubject) {
        validateNonRepeated(courseSubject);
        return courseSubjectService.save(courseSubject);
    }

    private void validateNonRepeated(CourseSubject courseSubject) {
        if (courseSubjectService.findById(courseSubject.getId()) != null) {
            throw new RuntimeException(COURSE_SUBJECT_REPEATED_MESSAGE);
        }
    }

}
