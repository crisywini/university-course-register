package co.perficient.university.controllers;

import co.perficient.university.application.service.coursesubject.*;
import co.perficient.university.model.CourseSubject;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping({"/course/course_subject", "/course_subject"})
public class CourseSubjectController {
    private final SaveCourseSubjectApplicationService saveCourseSubjectApplicationService;
    private final FindCourseSubjectByIdApplicationService findCourseSubjectByIdApplicationService;
    private final FindAllCourseSubjectsApplicationService findAllCourseSubjectsApplicationService;
    private final DeleteCourseSubjectApplicationService deleteCourseSubjectApplicationService;
    private final DeleteCourseSubjectByIdApplicationService deleteCourseSubjectByIdApplicationService;

    public CourseSubjectController(SaveCourseSubjectApplicationService saveCourseSubjectApplicationService,
                                   FindCourseSubjectByIdApplicationService findCourseSubjectByIdApplicationService,
                                   FindAllCourseSubjectsApplicationService findAllCourseSubjectsApplicationService,
                                   DeleteCourseSubjectApplicationService deleteCourseSubjectApplicationService,
                                   DeleteCourseSubjectByIdApplicationService deleteCourseSubjectByIdApplicationService) {
        this.saveCourseSubjectApplicationService = saveCourseSubjectApplicationService;
        this.findCourseSubjectByIdApplicationService = findCourseSubjectByIdApplicationService;
        this.findAllCourseSubjectsApplicationService = findAllCourseSubjectsApplicationService;
        this.deleteCourseSubjectApplicationService = deleteCourseSubjectApplicationService;
        this.deleteCourseSubjectByIdApplicationService = deleteCourseSubjectByIdApplicationService;
    }

    @PostMapping
    public void save(@RequestBody CourseSubject courseSubject) {
        saveCourseSubjectApplicationService.run(courseSubject);
    }

    @GetMapping("/course/course_subject/{id}")
    public CourseSubject findById(@RequestParam(name = "id") Long id) {
        return findCourseSubjectByIdApplicationService.run(id);
    }

    @GetMapping
    public Set<CourseSubject> findAll() {
        return findAllCourseSubjectsApplicationService.run();
    }

    @DeleteMapping("/course/course_subject/{id}")
    public void deleteById(@RequestParam(name = "id") Long id) {
        deleteCourseSubjectByIdApplicationService.run(id);
    }

    @DeleteMapping("/course/course_subject/{courseSubject}")
    public void delete(@RequestBody CourseSubject courseSubject) {
        deleteCourseSubjectApplicationService.run(courseSubject);
    }
}
