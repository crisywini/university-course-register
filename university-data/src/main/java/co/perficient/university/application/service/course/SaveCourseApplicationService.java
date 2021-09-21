package co.perficient.university.application.service.course;

import co.perficient.university.model.Course;
import co.perficient.university.service.course.SaveCourseService;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseApplicationService {

    private final SaveCourseService saveCourseService;

    public SaveCourseApplicationService(SaveCourseService saveCourseService) {
        this.saveCourseService = saveCourseService;
    }

    public Course run(Course course) {
        return saveCourseService.save(course);
    }
}
