package co.perficient.university.application.service.coursesubject;

import co.perficient.university.service.coursesubject.DeleteCourseSubjectByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseSubjectByIdApplicationService {

    private final DeleteCourseSubjectByIdService deleteCourseSubjectByIdService;

    public DeleteCourseSubjectByIdApplicationService(DeleteCourseSubjectByIdService deleteCourseSubjectByIdService) {
        this.deleteCourseSubjectByIdService = deleteCourseSubjectByIdService;
    }

    public void run(Long id) {
        deleteCourseSubjectByIdService.deleteById(id);
    }
}
