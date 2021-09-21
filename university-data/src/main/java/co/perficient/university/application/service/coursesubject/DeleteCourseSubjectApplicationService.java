package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.service.coursesubject.DeleteCourseSubjectService;

public class DeleteCourseSubjectApplicationService {
    private final DeleteCourseSubjectService deleteCourseSubjectService;

    public DeleteCourseSubjectApplicationService(DeleteCourseSubjectService deleteCourseSubjectService) {
        this.deleteCourseSubjectService = deleteCourseSubjectService;
    }

    public void run(CourseSubject courseSubject) {
        deleteCourseSubjectService.delete(courseSubject);
    }
}
