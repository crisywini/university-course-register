package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCourseSubjectService {
    private final CourseSubjectRepository courseSubjectRepository;

    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject cannot be updated because, does not exists!";

    public Optional<CourseSubjectDto> update(Long id, CourseSubject newCourseSubject) {
        validateCourseSubjectExisting(id);
        return courseSubjectRepository.update(id, newCourseSubject);
    }

    private void validateCourseSubjectExisting(Long id) {
        if (courseSubjectRepository.findById(id).isEmpty()) {
            throw new NullEntityException(NON_EXISTING_COURSE_SUBJECT_MESSAGE);
        }
    }
}
