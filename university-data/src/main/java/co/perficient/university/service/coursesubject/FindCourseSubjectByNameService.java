package co.perficient.university.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindCourseSubjectByNameService {
    private final CourseSubjectRepository courseSubjectRepository;

    public List<CourseSubjectDto> findByName(String name) {
        return courseSubjectRepository.findByName(name);
    }
}
