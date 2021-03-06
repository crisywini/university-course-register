package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCourseSubjectService {

    private final CourseSubjectRepository courseSubjectService;
    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject does not exists!";

    public void delete(CourseSubject courseSubject) {
        validateExisting(courseSubject);
        courseSubjectService.delete(courseSubject);
    }

    private void validateExisting(CourseSubject courseSubject) {
        if (courseSubjectService.findById(courseSubject.getId()).isEmpty()) {
            throw new NullEntityException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
