package co.perficient.university.controllers;

import co.perficient.university.application.service.course.*;
import co.perficient.university.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = {"/course"})
public class CourseController {

    private final SaveCourseApplicationService saveCourseApplicationService;
    private final FindCourseByIdApplicationService findCourseByIdApplicationService;
    private final FindAllCoursesApplicationService findAllCoursesApplicationService;
    private final DeleteCourseByIdApplicationService deleteCourseByIdApplicationService;
    private final DeleteCourseApplicationService deleteCourseApplicationService;

    public CourseController(SaveCourseApplicationService saveCourseApplicationService,
                            FindCourseByIdApplicationService findCourseByIdApplicationService,
                            FindAllCoursesApplicationService findAllCoursesApplicationService,
                            DeleteCourseByIdApplicationService deleteCourseByIdApplicationService,
                            DeleteCourseApplicationService deleteCourseApplicationService) {
        this.saveCourseApplicationService = saveCourseApplicationService;
        this.findCourseByIdApplicationService = findCourseByIdApplicationService;
        this.findAllCoursesApplicationService = findAllCoursesApplicationService;
        this.deleteCourseByIdApplicationService = deleteCourseByIdApplicationService;
        this.deleteCourseApplicationService = deleteCourseApplicationService;
    }


    @PostMapping
    public void save(@RequestBody Course course) {

        saveCourseApplicationService.run(course);
    }

    @GetMapping("/courses")
    public Set<Course> findAll() {
        return findAllCoursesApplicationService.run();
    }

    @GetMapping
    public Course findById(@RequestParam(name = "id") Long id) {
        return findCourseByIdApplicationService.run(id);
    }

    @DeleteMapping("/course/{course}")
    public void delete(@RequestBody Course course) {
        deleteCourseApplicationService.run(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteById(@RequestParam(name = "id") Long id) {
        deleteCourseByIdApplicationService.run(id);
    }


    private String getValue(Map<String, Object> json, String key) {
        return json.get(key).toString();
    }
}
