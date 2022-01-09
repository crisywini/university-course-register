package co.perficient.university.service.course;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import co.perficient.university.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindCourseByUserService {

    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";


    public List<CourseDto> findByUser(String userId) {
        return courseRepository.findByUser(getIdIfUserExists(userId));
    }

    private String getIdIfUserExists(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_USER_MESSAGE))
                .getId();
    }

}
