package co.perficient.university.service.coursesubject;


import co.perficient.university.model.Course;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseService;
import co.perficient.university.port.CourseSubjectService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCourseSubjectsService {

    private final CourseSubjectService courseSubjectService;

    public FindAllCourseSubjectsService(CourseSubjectService courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }


    public Set<CourseSubject> findAll() {
        return courseSubjectService.findAll();
    }


}
