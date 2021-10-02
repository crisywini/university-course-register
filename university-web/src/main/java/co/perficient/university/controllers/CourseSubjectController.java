package co.perficient.university.controllers;

import co.perficient.university.application.service.coursesubject.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    private final FindCourseSubjectByNameApplicationService findCourseSubjectByNameApplicationService;
    private final FindCourseSubjectByMethodologyApplicationService findCourseSubjectByMethodologyApplicationService;
    private final FindCourseSubjectByCourseApplicationService findCourseSubjectByCourseApplicationService;

    public CourseSubjectController(SaveCourseSubjectApplicationService saveCourseSubjectApplicationService,
                                   FindCourseSubjectByIdApplicationService findCourseSubjectByIdApplicationService,
                                   FindAllCourseSubjectsApplicationService findAllCourseSubjectsApplicationService,
                                   DeleteCourseSubjectApplicationService deleteCourseSubjectApplicationService,
                                   DeleteCourseSubjectByIdApplicationService deleteCourseSubjectByIdApplicationService,
                                   UpdateCourseSubjectApplicationService updateCourseSubjectApplicationService,
                                   FindCourseSubjectByNameApplicationService findCourseSubjectByNameApplicationService,
                                   FindCourseSubjectByMethodologyApplicationService findCourseSubjectByMethodologyApplicationService,
                                   FindCourseSubjectByCourseApplicationService findCourseSubjectByCourseApplicationService) {
        this.saveCourseSubjectApplicationService = saveCourseSubjectApplicationService;
        this.findCourseSubjectByIdApplicationService = findCourseSubjectByIdApplicationService;
        this.findAllCourseSubjectsApplicationService = findAllCourseSubjectsApplicationService;
        this.deleteCourseSubjectApplicationService = deleteCourseSubjectApplicationService;
        this.deleteCourseSubjectByIdApplicationService = deleteCourseSubjectByIdApplicationService;
        this.updateCourseSubjectApplicationService = updateCourseSubjectApplicationService;
        this.findCourseSubjectByNameApplicationService = findCourseSubjectByNameApplicationService;
        this.findCourseSubjectByMethodologyApplicationService = findCourseSubjectByMethodologyApplicationService;
        this.findCourseSubjectByCourseApplicationService = findCourseSubjectByCourseApplicationService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody CourseSubject courseSubject) {
        CourseSubjectDto saved = null;
        try {
            saved = saveCourseSubjectApplicationService.run(courseSubject);
        } catch (RepeatedEntityException | NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CourseSubjectDto> findById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(findCourseSubjectByIdApplicationService.run(id), HttpStatus.OK);
    }

    @GetMapping("/course_subjects")
    public ResponseEntity<Set<CourseSubjectDto>> findAll() {
        return new ResponseEntity<>(findAllCourseSubjectsApplicationService.run(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") Long id) {
        try {
            deleteCourseSubjectByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + id + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/course")
    public ResponseEntity<String> delete(@RequestBody CourseSubject courseSubject) {
        try {
            deleteCourseSubjectApplicationService.run(courseSubject);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + courseSubject.getId() + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody CourseSubject courseSubject) {
        CourseSubjectDto updated = null;
        try {
            updated = updateCourseSubjectApplicationService.run(id, courseSubject);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/course_subjects/byName")
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(findCourseSubjectByNameApplicationService.run(name), HttpStatus.OK);
    }

    @GetMapping("/course_subjects/byCourse")
    public ResponseEntity<?> findByCourse(@RequestParam("course") Long courseId) {
        List<CourseSubjectDto> byCourse = null;
        try {
            String course = courseId+"";
            courseId = Long.parseLong(course);
            byCourse = findCourseSubjectByCourseApplicationService.run(courseId);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byCourse, HttpStatus.OK);
    }

    @GetMapping("/course_subjects/byMethodology")
    public ResponseEntity<?> findByMethodology(@RequestParam("methodology") String methodology) {
        List<CourseSubjectDto> byMethodology = null;
        try {
            byMethodology = findCourseSubjectByMethodologyApplicationService.run(Methodology.of(methodology));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byMethodology, HttpStatus.OK);
    }

}
