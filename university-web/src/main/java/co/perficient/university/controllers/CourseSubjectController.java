package co.perficient.university.controllers;

import co.perficient.university.application.service.coursesubject.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.model.mapper.CourseSubjectMapper;
import java.util.Optional;
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
    private final CourseSubjectApplicationService courseSubjectApplicationService;
    private final CourseSubjectMapper courseSubjectMapper;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody CourseSubject courseSubject) {
        Optional<CourseSubjectDto> saved;
        try {
            saved = courseSubjectApplicationService.save(courseSubject).map(courseSubjectMapper::courseSubjectToCourseSubjectDto);
        } catch (RepeatedEntityException | NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourseSubjectDto>> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(courseSubjectApplicationService.findById(id)
                .map(courseSubjectMapper::courseSubjectToCourseSubjectDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<CourseSubjectDto>> findAll() {
        return new ResponseEntity<>(courseSubjectApplicationService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        try {
            courseSubjectApplicationService.deleteById(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + id + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody CourseSubject courseSubject) {
        try {
            courseSubjectApplicationService.delete(courseSubject);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The course subject " + courseSubject.getId() + " was removed correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody CourseSubject courseSubject) {
        Optional<CourseSubjectDto> updated;
        try {
            updated = courseSubjectApplicationService.update(id, courseSubject)
                    .map(courseSubjectMapper::courseSubjectToCourseSubjectDto);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(courseSubjectApplicationService.findByName("%" + name + "%"), HttpStatus.OK);
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<?> findByCourse(@PathVariable("course") Long courseId) {
        List<CourseSubjectDto> byCourse;
        try {
            String course = courseId + "";
            courseId = Long.parseLong(course);
            byCourse = courseSubjectApplicationService.findByCourse(courseId);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byCourse, HttpStatus.OK);
    }

    @GetMapping("/methodology/{methodology}")
    public ResponseEntity<?> findByMethodology(@PathVariable("methodology") String methodology) {
        List<CourseSubjectDto> byMethodology;
        try {
            byMethodology = courseSubjectApplicationService.findByMethodology(Methodology.of(methodology));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(byMethodology, HttpStatus.OK);
    }

}
