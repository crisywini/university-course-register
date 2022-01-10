package co.perficient.university.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindCourseSubjectByIdService {

    private final CourseSubjectRepository courseSubjectService;


    public Optional<CourseSubjectDto> findById(Long id) {
        return courseSubjectService.findById(id);
    }
}
