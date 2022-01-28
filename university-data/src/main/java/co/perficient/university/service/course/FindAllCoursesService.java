package co.perficient.university.service.course;


import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class FindAllCoursesService {

    private final CourseRepository courseRepository;

    public Set<Course> findAll() {
        return courseRepository.findAll();
    }


}
