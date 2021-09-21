package co.perficient.university.application.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.service.course.FindCourseByIdService;

public class FindCourseByIdApplicationService {

    private final FindCourseByIdService findCourseByIdService;

    public FindCourseByIdApplicationService(FindCourseByIdService findCourseByIdService) {
        this.findCourseByIdService = findCourseByIdService;
    }

    public Course run(Long id) {
        return findCourseByIdService.findById(id);
    }
}
