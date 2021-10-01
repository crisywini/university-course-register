package co.perficient.university.application.service.course;

import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.FindCourseByUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCoursesByUserApplicationService {
    private final FindCourseByUserService findCourseByUserService;

    public FindCoursesByUserApplicationService(FindCourseByUserService findCourseByUserService) {
        this.findCourseByUserService = findCourseByUserService;
    }

    public List<CourseDto> run(String userId) {
        return findCourseByUserService.findByUser(userId);
    }
}
