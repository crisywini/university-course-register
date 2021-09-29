package co.perficient.university.application.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.UpdateCourseService;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseApplicationService {
    private final UpdateCourseService updateCourseService;

    public UpdateCourseApplicationService(UpdateCourseService updateCourseService) {
        this.updateCourseService = updateCourseService;
    }

    public CourseDto run(Long id, Course newCourse) {
        return updateCourseService.update(id, newCourse);
    }
}
