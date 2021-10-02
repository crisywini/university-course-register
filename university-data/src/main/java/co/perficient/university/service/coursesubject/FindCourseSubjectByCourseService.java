package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseSubjectByCourseService {
    private final CourseSubjectRepository courseSubjectRepository;
    private final CourseRepository courseRepository;
    private final static String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";

    public FindCourseSubjectByCourseService(CourseSubjectRepository courseSubjectRepository,
                                            CourseRepository courseRepository) {
        this.courseSubjectRepository = courseSubjectRepository;
        this.courseRepository = courseRepository;
    }

    public List<CourseSubjectDto> findByCourse(Long courseId) {
        validateExistingCourse(courseId);
        return courseSubjectRepository.findByCourse(courseId);
    }

    private void validateExistingCourse(Long courseId) {
        if (courseRepository.findById(courseId) == null) {
            throw new NullEntityException(NON_EXISTING_COURSE_MESSAGE);
        }
    }
}
