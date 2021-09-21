package co.perficient.university.application.service.course;

import co.perficient.university.service.course.DeleteCourseByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseByIdApplicationService {
    private final DeleteCourseByIdService deleteCourseByIdService;

    public DeleteCourseByIdApplicationService(DeleteCourseByIdService deleteCourseByIdService) {
        this.deleteCourseByIdService = deleteCourseByIdService;
    }

    public void run(Long id) {
        deleteCourseByIdService.deleteById(id);
    }
}
