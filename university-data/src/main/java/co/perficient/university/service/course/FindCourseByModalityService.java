package co.perficient.university.service.course;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseByModalityService {
    private final CourseRepository courseRepository;
    private static final String MODALITY_NOT_FOUND_MESSAGE = "The modality was not found!";

    public FindCourseByModalityService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findByModality(Modality modality) {
        validateModalityNotDefault(modality);
        return courseRepository.findByModality(modality);
    }

    private void validateModalityNotDefault(Modality modality) {
        if (modality.equals(Modality.n)) {
            throw new ParamNotFoundException(MODALITY_NOT_FOUND_MESSAGE);
        }
    }
}
