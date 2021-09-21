package co.perficient.university.application.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.service.course.DeleteCoursesService;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseApplicationService {

    private final DeleteCoursesService deleteCoursesService;

    public DeleteCourseApplicationService(DeleteCoursesService deleteCoursesService) {
        this.deleteCoursesService = deleteCoursesService;
    }

    public void run(Course course) {
        deleteCoursesService.delete(course);
    }
}
