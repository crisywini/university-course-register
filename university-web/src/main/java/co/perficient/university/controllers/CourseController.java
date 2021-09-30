package co.perficient.university.controllers;

import co.perficient.university.application.service.course.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = {"/course"})
public class CourseController {

    private final SaveCourseApplicationService saveCourseApplicationService;
    private final FindCourseByIdApplicationService findCourseByIdApplicationService;
    private final FindAllCoursesApplicationService findAllCoursesApplicationService;
    private final DeleteCourseByIdApplicationService deleteCourseByIdApplicationService;
    private final DeleteCourseApplicationService deleteCourseApplicationService;
    private final UpdateCourseApplicationService updateCourseApplicationService;
    private final FindCourseByAcademicLevelApplicationService findCourseByAcademicLevelApplicationService;


    public CourseController(SaveCourseApplicationService saveCourseApplicationService,
                            FindCourseByIdApplicationService findCourseByIdApplicationService,
                            FindAllCoursesApplicationService findAllCoursesApplicationService,
                            DeleteCourseByIdApplicationService deleteCourseByIdApplicationService,
                            DeleteCourseApplicationService deleteCourseApplicationService,
                            UpdateCourseApplicationService updateCourseApplicationService,
                            FindCourseByAcademicLevelApplicationService findCourseByAcademicLevelApplicationService) {
        this.saveCourseApplicationService = saveCourseApplicationService;
        this.findCourseByIdApplicationService = findCourseByIdApplicationService;
        this.findAllCoursesApplicationService = findAllCoursesApplicationService;
        this.deleteCourseByIdApplicationService = deleteCourseByIdApplicationService;
        this.deleteCourseApplicationService = deleteCourseApplicationService;
        this.updateCourseApplicationService = updateCourseApplicationService;
        this.findCourseByAcademicLevelApplicationService = findCourseByAcademicLevelApplicationService;
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Course course) {
        CourseDto saved = null;
        try {
            saved = saveCourseApplicationService.run(course);
        } catch (RepeatedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<Set<CourseDto>> findAll() {
        return new ResponseEntity<>(findAllCoursesApplicationService.run(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CourseDto> findById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(findCourseByIdApplicationService.run(id), HttpStatus.OK);
    }

    @GetMapping("/courses/byAcademicLevel")
    public ResponseEntity<List<CourseDto>> findByAcademicLevel(@RequestParam(name = "academic_level") AcademicLevel academicLevel) {

        return new ResponseEntity<>(findCourseByAcademicLevelApplicationService.run(academicLevel), HttpStatus.OK);
    }


    @DeleteMapping("/course")
    public ResponseEntity<String> delete(@RequestBody Course course) {
        try {
            deleteCourseApplicationService.run(course);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + course.getId() + " removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") Long id) {
        try {
            deleteCourseByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + id + " removed";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Course course) {
        CourseDto updated = null;
        try {
            updated = updateCourseApplicationService.run(id, course);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
