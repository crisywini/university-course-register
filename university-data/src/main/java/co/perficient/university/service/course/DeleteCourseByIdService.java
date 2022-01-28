package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseByIdService {

    private final CourseRepository courseRepository;

    private static final String NON_EXISTING_COURSE_MESSAGE = "The course does not exists!";

    public DeleteCourseByIdService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(getIdIfCourseIsPresent(id));
    }

    private Long getIdIfCourseIsPresent(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_COURSE_MESSAGE))
                .getId();
    }

}
