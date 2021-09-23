package co.perficient.university.controllers;

import co.perficient.university.application.service.course.*;
import co.perficient.university.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = {"/", "/course"})
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
    public Course save(@RequestBody Map<String, Object> json) {
        String name = getValue(json, "name");
        String title = getValue(json, "title");
        AcademicLevel academicLevel = AcademicLevel.valueOf(getValue(json, "academicLevel"));
        Faculty faculty = Faculty.valueOf(getValue(json, "faculty"));
        Modality modality = Modality.valueOf(getValue(json, "modality"));
        int totalAcademicCredits = Integer.parseInt(getValue(json, "totalAcademicCredits"));
        String qualifiedRegistration = getValue(json, "qualifiedRegistration");
        String highQualityAccreditation = getValue(json, "highQualityAccreditation");
        EducationLevel educationLevel = EducationLevel.valueOf(getValue(json, "educationLevel"));
        Course course = new Course(name, title, academicLevel, faculty, modality, totalAcademicCredits,
                qualifiedRegistration, highQualityAccreditation, educationLevel);
        return saveCourseApplicationService.run(course);
    }

    @GetMapping
    public Set<Course> findAll() {
        return findAllCoursesApplicationService.run();
    }

    @GetMapping
    public Course findById(Long id) {
        return findCourseByIdApplicationService.run(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Course course) {

    }


    private String getValue(Map<String, Object> json, String key) {
        return json.get(key).toString();
    }
}
