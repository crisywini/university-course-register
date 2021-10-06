package co.perficient.university.controllers;

import co.perficient.university.application.service.course.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = {"/api/courses"})
@RequiredArgsConstructor
public class CourseController {

    private final SaveCourseApplicationService saveCourseApplicationService;
    private final FindCourseByIdApplicationService findCourseByIdApplicationService;
    private final FindAllCoursesApplicationService findAllCoursesApplicationService;
    private final DeleteCourseByIdApplicationService deleteCourseByIdApplicationService;
    private final DeleteCourseApplicationService deleteCourseApplicationService;
    private final UpdateCourseApplicationService updateCourseApplicationService;
    private final FindCourseByAcademicLevelApplicationService findCourseByAcademicLevelApplicationService;
    private final FindCoursesByUserApplicationService findCoursesByUserApplicationService;
    private final FindCoursesByModalityApplicationService findCoursesByModalityApplicationService;
    private final FindCoursesByNameApplicationService findCoursesByNameApplicationService;
    private final FindCoursesByFacultyApplicationService findCoursesByFacultyApplicationService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Course course) {
        CourseDto saved;
        try {
            saved = saveCourseApplicationService.run(course);
        } catch (RepeatedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<CourseDto>> findAll() {
        return new ResponseEntity<>(findAllCoursesApplicationService.run(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(findCourseByIdApplicationService.run(id), HttpStatus.OK);
    }

    @GetMapping("/academic_level/{academic_level}")
    public ResponseEntity<?> findByAcademicLevel(@PathVariable(name = "academic_level") String academicLevel) {
        List<CourseDto> courses;
        try {
            courses = findCourseByAcademicLevelApplicationService.run(AcademicLevel.of(academicLevel));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/faculty/{faculty}")
    public ResponseEntity<?> findByFaculty(@PathVariable(name = "faculty") String faculty) {
        List<CourseDto> courses;
        try {
            courses = findCoursesByFacultyApplicationService.run(Faculty.of(faculty));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/modality/{modality}")
    public ResponseEntity<?> findByModality(@PathVariable(name = "modality") String modality) {
        List<CourseDto> courses;
        try {
            courses = findCoursesByModalityApplicationService.run(Modality.of(modality));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<?> findByUser(@PathVariable(name = "user") String user) {
        List<CourseDto> courses;
        try {
            courses = findCoursesByUserApplicationService.run(user);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable(name = "name") String name) {
        List<CourseDto> courses = findCoursesByNameApplicationService.run("%" + name + "%");
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Course course) {
        try {
            deleteCourseApplicationService.run(course);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + course.getId() + " removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        try {
            deleteCourseByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + id + " removed";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Course course) {
        CourseDto updated;
        try {
            updated = updateCourseApplicationService.run(id, course);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}