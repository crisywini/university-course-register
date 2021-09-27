package co.perficient.university.controllers;

import co.perficient.university.application.service.coursesubject.*;
import co.perficient.university.model.CourseSubject;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = {"/course/course_subject", "/course_subject"})
public class CourseSubjectController {
    private final SaveCourseSubjectApplicationService saveCourseSubjectApplicationService;
    private final FindCourseSubjectByIdApplicationService findCourseSubjectByIdApplicationService;
    private final FindAllCourseSubjectsApplicationService findAllCourseSubjectsApplicationService;
    private final DeleteCourseSubjectApplicationService deleteCourseSubjectApplicationService;
    private final DeleteCourseSubjectByIdApplicationService deleteCourseSubjectByIdApplicationService;
    private final UpdateCourseSubjectApplicationService updateCourseSubjectApplicationService;

    public CourseSubjectController(SaveCourseSubjectApplicationService saveCourseSubjectApplicationService,
                                   FindCourseSubjectByIdApplicationService findCourseSubjectByIdApplicationService,
                                   FindAllCourseSubjectsApplicationService findAllCourseSubjectsApplicationService,
                                   DeleteCourseSubjectApplicationService deleteCourseSubjectApplicationService,
                                   DeleteCourseSubjectByIdApplicationService deleteCourseSubjectByIdApplicationService,
                                   UpdateCourseSubjectApplicationService updateCourseSubjectApplicationService) {
        this.saveCourseSubjectApplicationService = saveCourseSubjectApplicationService;
        this.findCourseSubjectByIdApplicationService = findCourseSubjectByIdApplicationService;
        this.findAllCourseSubjectsApplicationService = findAllCourseSubjectsApplicationService;
        this.deleteCourseSubjectApplicationService = deleteCourseSubjectApplicationService;
        this.deleteCourseSubjectByIdApplicationService = deleteCourseSubjectByIdApplicationService;
        this.updateCourseSubjectApplicationService = updateCourseSubjectApplicationService;
    }

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody CourseSubject courseSubject) {
        saveCourseSubjectApplicationService.run(courseSubject);
    }

    @GetMapping
    public CourseSubject findById(@RequestParam(name = "id") Long id) {
        return findCourseSubjectByIdApplicationService.run(id);
    }

    @GetMapping("/courses")
    public Set<CourseSubject> findAll() {
        return findAllCourseSubjectsApplicationService.run();
    }

    @DeleteMapping
    public void deleteById(@RequestParam(name = "id") Long id) {
        deleteCourseSubjectByIdApplicationService.run(id);
    }

    @DeleteMapping("/course")
    public void delete(@RequestBody CourseSubject courseSubject) {
        deleteCourseSubjectApplicationService.run(courseSubject);
    }

    @PutMapping
    public CourseSubject update(@RequestParam(name = "id") Long id,
                                @RequestBody CourseSubject courseSubject) {
        return updateCourseSubjectApplicationService.run(id, courseSubject);
    }
}
