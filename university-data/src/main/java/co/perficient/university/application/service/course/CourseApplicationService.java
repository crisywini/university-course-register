package co.perficient.university.application.service.course;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseApplicationService {
    private final SaveCourseService saveCourseService;
    private final DeleteCoursesService deleteCoursesService;
    private final DeleteCourseByIdService deleteCourseByIdService;
    private final FindAllCoursesService findAllCoursesService;
    private final FindCourseByAcademicLevelService findCourseByAcademicLevelService;
    private final FindCourseByFacultyService findCourseByFacultyService;
    private final FindCourseByIdService findCourseByIdService;
    private final FindCourseByModalityService findCourseByModalityService;
    private final FindCourseByNameService findCourseByNameService;
    private final FindCourseByUserService findCourseByUserService;
    private final UpdateCourseService updateCourseService;

    public CourseDto saveCourse(Course course) {
        return saveCourseService.save(course);
    }

    public void deleteCourse(Course course) {
        deleteCoursesService.delete(course);
    }

    public void deleteCourseById(Long id) {
        deleteCourseByIdService.deleteById(id);
    }

    public Set<CourseDto> findAllCourses() {
        return findAllCoursesService.findAll();
    }

    public List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel) {
        return findCourseByAcademicLevelService.findByAcademicLevel(academicLevel);
    }

    public List<CourseDto> findByFaculty(Faculty faculty) {
        return findCourseByFacultyService.findByFaculty(faculty);
    }

    public CourseDto findById(Long id) {
        return findCourseByIdService.findById(id);
    }

    public List<CourseDto> findByModality(Modality modality) {
        return findCourseByModalityService.findByModality(modality);
    }

    public List<CourseDto> findByName(String name) {
        return findCourseByNameService.findByName(name);
    }

    public List<CourseDto> findByUser(String userId) {
        return findCourseByUserService.findByUser(userId);
    }

    public CourseDto update(Long id, Course course) {
        return updateCourseService.update(id, course);
    }


}
