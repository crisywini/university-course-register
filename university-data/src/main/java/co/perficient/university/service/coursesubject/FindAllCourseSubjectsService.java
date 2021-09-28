package co.perficient.university.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCourseSubjectsService {

    private final CourseSubjectRepository courseSubjectService;

    public FindAllCourseSubjectsService(CourseSubjectRepository courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }


    public Set<CourseSubjectDto> findAll() {
        return courseSubjectService.findAll();
    }


}
