package co.perficient.university.service.coursesubject;


import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCourseSubjectsService {

    private final CourseSubjectRepository courseSubjectService;

    public FindAllCourseSubjectsService(CourseSubjectRepository courseSubjectService) {
        this.courseSubjectService = courseSubjectService;
    }


    public Set<CourseSubject> findAll() {
        return courseSubjectService.findAll();
    }


}
