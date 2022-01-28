package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindCourseSubjectByIdService {

    private final CourseSubjectRepository courseSubjectRepository;


    public Optional<CourseSubject> findById(Long id) {
        return courseSubjectRepository.findById(id);
    }
}
