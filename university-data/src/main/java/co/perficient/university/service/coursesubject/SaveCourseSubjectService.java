package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.Course;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseSubjectService {

    private final CourseSubjectRepository courseSubjectService;
    private final CourseRepository courseRepository;
    private static final String COURSE_SUBJECT_REPEATED_MESSAGE = "The course subject already exists!";
    private static final String COURSE_NON_EXISTING_MESSAGE = "The course does not exists!";

    public SaveCourseSubjectService(CourseSubjectRepository courseSubjectService, CourseRepository courseRepository) {
        this.courseSubjectService = courseSubjectService;
        this.courseRepository = courseRepository;
    }

    public CourseSubjectDto save(CourseSubject courseSubject) {
        validateNonRepeated(courseSubject);
        validateExistingCourse(courseSubject.getCourse());
        return courseSubjectService.save(courseSubject);
    }

    private void validateExistingCourse(Course course) {
        if (course == null || courseRepository.findById(course.getId()) == null) {
            throw new NullEntityException(COURSE_NON_EXISTING_MESSAGE);
        }
    }

    private void validateNonRepeated(CourseSubject courseSubject) {
        if (courseSubject.getId() != null && courseSubjectService.findById(courseSubject.getId()) != null) {
            throw new RepeatedEntityException(COURSE_SUBJECT_REPEATED_MESSAGE);
        }
    }

}
