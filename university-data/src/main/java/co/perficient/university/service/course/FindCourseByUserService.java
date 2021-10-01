package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByUserService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public FindCourseByUserService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<CourseDto> findByUser(String userId) {
        validateUserExisting(userId);
        return courseRepository.findByUser(userId);
    }

    public void validateUserExisting(String userId) {
        if (userRepository.findById(userId) == null) {
            throw new NullEntityException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
