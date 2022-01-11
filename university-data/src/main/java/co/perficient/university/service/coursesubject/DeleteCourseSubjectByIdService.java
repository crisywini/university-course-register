package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.port.CourseSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCourseSubjectByIdService {

    private final CourseSubjectRepository courseSubjectRepository;

    private static final String NON_EXISTING_COURSE_SUBJECT_MESSAGE = "The course subject does not exists!";

    public void deleteById(Long id) {
        courseSubjectRepository.deleteById(getIdIfCourseSubjectExists(id));
    }

    private Long getIdIfCourseSubjectExists(Long id) {
        return courseSubjectRepository.findById(id)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_COURSE_SUBJECT_MESSAGE))
                .getId();
    }

}
