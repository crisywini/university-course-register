package co.perficient.university.controllers;

import co.perficient.university.application.service.course.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.mapper.CourseMapper;
import java.util.Optional;
import java.util.stream.Collectors;
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

    private final CourseApplicationService courseApplicationService;
    private final CourseMapper courseMapper;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Course course) {
        Optional<CourseDto> saved;
        try {
            saved = courseApplicationService.saveCourse(course).map(courseMapper::courseToCourseDto);
        } catch (RepeatedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<CourseDto>> findAll() {
        return new ResponseEntity<>(courseApplicationService.findAllCourses().stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourseDto>> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(courseApplicationService.findById(id)
                .map(courseMapper::courseToCourseDto), HttpStatus.OK);
    }

    @GetMapping("/academic_level/{academic_level}")
    public ResponseEntity<?> findByAcademicLevel(@PathVariable(name = "academic_level") String academicLevel) {
        List<CourseDto> courses;
        try {
            courses = courseApplicationService.findByAcademicLevel(AcademicLevel.of(academicLevel));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/faculty/{faculty}")
    public ResponseEntity<?> findByFaculty(@PathVariable(name = "faculty") String faculty) {
        List<CourseDto> courses;
        try {
            courses = courseApplicationService.findByFaculty(Faculty.of(faculty));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/modality/{modality}")
    public ResponseEntity<?> findByModality(@PathVariable(name = "modality") String modality) {
        List<CourseDto> courses;
        try {
            courses = courseApplicationService.findByModality(Modality.of(modality));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<?> findByUser(@PathVariable(name = "user") String user) {
        List<CourseDto> courses;
        try {
            courses = courseApplicationService.findByUser(user);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable(name = "name") String name) {
        List<CourseDto> courses = courseApplicationService.findByName("%" + name + "%");
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Course course) {
        try {
            courseApplicationService.deleteCourse(course);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + course.getId() + " removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        try {
            courseApplicationService.deleteCourseById(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "Course: " + id + " removed";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Course course) {
        Optional<CourseDto> updated;
        try {
            updated = courseApplicationService.update(id, course).map(courseMapper::courseToCourseDto);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}