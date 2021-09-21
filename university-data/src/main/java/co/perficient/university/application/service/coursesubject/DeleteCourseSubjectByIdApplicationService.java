package co.perficient.university.application.service.coursesubject;

import co.perficient.university.service.coursesubject.DeleteCourseSubjectByIdService;

public class DeleteCourseSubjectByIdApplicationService {

    private final DeleteCourseSubjectByIdService deleteCourseSubjectByIdService;

    public DeleteCourseSubjectByIdApplicationService(DeleteCourseSubjectByIdService deleteCourseSubjectByIdService) {
        this.deleteCourseSubjectByIdService = deleteCourseSubjectByIdService;
    }

    public void run(Long id) {
        deleteCourseSubjectByIdService.deleteById(id);
    }
}
