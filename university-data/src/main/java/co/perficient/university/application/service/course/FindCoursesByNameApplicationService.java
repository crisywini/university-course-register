package co.perficient.university.application.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCoursesByNameApplicationService {

    private final FindCourseByNameService findCourseByNameService;

    public FindCoursesByNameApplicationService(FindCourseByNameService findCourseByNameService) {
        this.findCourseByNameService = findCourseByNameService;
    }

    public List<CourseDto> run(String name) {
        return findCourseByNameService.findByName(name);
    }
}
