package co.perficient.university.application.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByIdService;
import org.springframework.stereotype.Service;

@Service
public class FindCourseByIdApplicationService {

    private final FindCourseByIdService findCourseByIdService;

    public FindCourseByIdApplicationService(FindCourseByIdService findCourseByIdService) {
        this.findCourseByIdService = findCourseByIdService;
    }

    public CourseDto run(Long id) {
        return findCourseByIdService.findById(id);
    }
}
