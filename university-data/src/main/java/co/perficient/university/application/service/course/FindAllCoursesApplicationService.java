package co.perficient.university.application.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindAllCoursesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class FindAllCoursesApplicationService {

    private final FindAllCoursesService findAllCoursesService;

    public FindAllCoursesApplicationService(FindAllCoursesService findAllCoursesService) {
        this.findAllCoursesService = findAllCoursesService;
    }

    public Set<CourseDto> run() {
        return findAllCoursesService.findAll();
    }
}
