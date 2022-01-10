package co.perficient.university.service.course;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindCourseByFacultyService {

    private final CourseRepository courseRepository;

    private static final String FACULTY_LEVEL_NOT_FOUND_MESSAGE = "The faculty was not found!";

    public List<CourseDto> findByFaculty(Faculty faculty) {
        validateFacultyNotDefault(faculty);
        return courseRepository.findByFaculty(faculty);
    }

    private void validateFacultyNotDefault(Faculty faculty) {
        if (faculty.equals(Faculty.n)) {
            throw new ParamNotFoundException(FACULTY_LEVEL_NOT_FOUND_MESSAGE);
        }
    }
}
