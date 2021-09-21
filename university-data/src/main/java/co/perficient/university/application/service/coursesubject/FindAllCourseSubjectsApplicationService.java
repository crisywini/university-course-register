package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.service.coursesubject.FindAllCourseSubjectsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCourseSubjectsApplicationService {

    private final FindAllCourseSubjectsService findAllCourseSubjectsService;

    public FindAllCourseSubjectsApplicationService(FindAllCourseSubjectsService findAllCourseSubjectsService) {
        this.findAllCourseSubjectsService = findAllCourseSubjectsService;
    }

    public Set<CourseSubject> run() {
        return findAllCourseSubjectsService.findAll();
    }
}
