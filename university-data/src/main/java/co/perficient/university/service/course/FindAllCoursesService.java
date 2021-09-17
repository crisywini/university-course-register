package co.perficient.university.service.course;


import co.perficient.university.model.Course;
import co.perficient.university.port.CourseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCoursesService {

    private final CourseService courseService;

    public FindAllCoursesService(CourseService courseService) {
        this.courseService = courseService;
    }


    public Set<Course> findAll() {
        return courseService.findAll();
    }


}
