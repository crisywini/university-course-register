package co.perficient.university.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class FindAllCourseSubjectsService {

    private final CourseSubjectRepository courseSubjectService;

    public Set<CourseSubject> findAll() {
        return courseSubjectService.findAll();
    }


}
