package co.perficient.university.service.coursesubject;

import co.perficient.university.model.Course;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseService;
import co.perficient.university.port.CourseSubjectService;
import org.springframework.stereotype.Service;

@Service
public class FindCourseSubjectByIdService {

    private final CourseSubjectService courseSubjectService;

    public FindCourseSubjectByIdService(CourseSubjectService courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }

    public CourseSubject findById(Long id) {
        return courseSubjectService.findById(id);
    }
}
