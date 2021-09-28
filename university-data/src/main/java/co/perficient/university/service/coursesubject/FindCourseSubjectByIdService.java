package co.perficient.university.service.coursesubject;

import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class FindCourseSubjectByIdService {

    private final CourseSubjectRepository courseSubjectService;

    public FindCourseSubjectByIdService(CourseSubjectRepository courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public CourseSubjectDto findById(Long id) {
        return courseSubjectService.findById(id);
    }
}
