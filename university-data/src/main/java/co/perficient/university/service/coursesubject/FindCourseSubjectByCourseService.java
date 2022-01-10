package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.CourseSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindCourseSubjectByCourseService {

    private final CourseSubjectRepository courseSubjectRepository;

    private final CourseRepository courseRepository;

    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";


    public List<CourseSubjectDto> findByCourse(Long courseId) {
        return courseSubjectRepository.findByCourse(getIdIfCourseSubjectExists(courseId));
    }

    private Long getIdIfCourseSubjectExists(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_COURSE_MESSAGE))
                .getId();
    }

}
