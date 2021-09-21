package co.perficient.university.service.coursesubject;

import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseSubjectByIdService {

    private final CourseSubjectRepository courseSubjectService;
    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject does not exists!";

    public DeleteCourseSubjectByIdService(CourseSubjectRepository courseService) {
        this.courseSubjectService = courseService;
    }

    public void deleteById(Long id) {
        validateExisting(id);
        courseSubjectService.deleteById(id);
    }

    private void validateExisting(Long id) {
        if (courseSubjectService.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
