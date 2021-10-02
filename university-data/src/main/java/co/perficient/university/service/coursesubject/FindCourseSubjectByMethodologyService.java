package co.perficient.university.service.coursesubject;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseSubjectByMethodologyService {
    private final CourseSubjectRepository courseSubjectRepository;
    private final static String METHODOLOGY_DEFAULT_MESSAGE = "The methodology was not found!";

    public FindCourseSubjectByMethodologyService(CourseSubjectRepository courseSubjectRepository) {
        this.courseSubjectRepository = courseSubjectRepository;
    }

    public List<CourseSubjectDto> findByMethodology(Methodology methodology) {
        validateNotDefaultMethodology(methodology);
        return courseSubjectRepository.findByMethodology(methodology);
    }

    private void validateNotDefaultMethodology(Methodology methodology) {
        if (methodology.equals(Methodology.n)) {
            throw new ParamNotFoundException(METHODOLOGY_DEFAULT_MESSAGE);
        }
    }

}
