package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseSubjectService {
    private final CourseSubjectRepository courseSubjectRepository;
    private final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject cannot be updated because, does not exists!";


    public UpdateCourseSubjectService(CourseSubjectRepository courseSubjectRepository) {
        this.courseSubjectRepository = courseSubjectRepository;
    }

    public CourseSubjectDto update(Long id, CourseSubject newCourseSubject) {
        validateCourseSubjectExisting(id);
        return courseSubjectRepository.update(id, newCourseSubject);
    }

    private void validateCourseSubjectExisting(Long id) {
        if (courseSubjectRepository.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
