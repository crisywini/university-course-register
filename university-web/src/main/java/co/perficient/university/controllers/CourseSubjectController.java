package co.perficient.university.controllers;

import co.perficient.university.application.service.coursesubject.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = {"/api/course_subjects"})
@RequiredArgsConstructor
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


    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody CourseSubject courseSubject) {
        CourseSubjectDto saved;
        try {
            saved = saveCourseSubjectApplicationService.run(courseSubject);
        } catch (RepeatedEntityException | NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseSubjectDto> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(findCourseSubjectByIdApplicationService.run(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<CourseSubjectDto>> findAll() {
        return new ResponseEntity<>(findAllCourseSubjectsApplicationService.run(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        try {
            deleteCourseSubjectByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + id + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody CourseSubject courseSubject) {
        try {
            deleteCourseSubjectApplicationService.run(courseSubject);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + courseSubject.getId() + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody CourseSubject courseSubject) {
        CourseSubjectDto updated;
        try {
            updated = updateCourseSubjectApplicationService.run(id, courseSubject);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(findCourseSubjectByNameApplicationService.run("%" + name + "%"), HttpStatus.OK);
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<?> findByCourse(@PathVariable("course") Long courseId) {
        List<CourseSubjectDto> byCourse;
        try {
            String course = courseId + "";
            courseId = Long.parseLong(course);
            byCourse = findCourseSubjectByCourseApplicationService.run(courseId);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byCourse, HttpStatus.OK);
    }

    @GetMapping("/methodology/{methodology}")
    public ResponseEntity<?> findByMethodology(@PathVariable("methodology") String methodology) {
        List<CourseSubjectDto> byMethodology;
        try {
            byMethodology = findCourseSubjectByMethodologyApplicationService.run(Methodology.of(methodology));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byMethodology, HttpStatus.OK);
    }

}
