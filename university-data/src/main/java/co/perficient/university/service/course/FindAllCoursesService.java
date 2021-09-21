package co.perficient.university.service.course;


import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllCoursesService {

    private final CourseRepository courseRepository;

    public FindAllCoursesService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public Set<Course> findAll() {
        return courseRepository.findAll();
    }


}
