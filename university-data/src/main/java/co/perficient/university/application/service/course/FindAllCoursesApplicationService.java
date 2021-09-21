package co.perficient.university.application.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.service.course.FindAllCoursesService;

import java.util.Set;

public class FindAllCoursesApplicationService {

    private final FindAllCoursesService findAllCoursesService;

    public FindAllCoursesApplicationService(FindAllCoursesService findAllCoursesService) {
        this.findAllCoursesService = findAllCoursesService;
    }

    public Set<Course> run() {
        return findAllCoursesService.findAll();
    }
}
