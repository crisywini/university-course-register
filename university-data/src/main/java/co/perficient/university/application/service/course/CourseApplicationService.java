package co.perficient.university.application.service.course;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.service.course.*;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import lombok.val;

@Service
@RequiredArgsConstructor
public class CourseApplicationService {

    val saveCourseService;

    val deleteCoursesService;

    val deleteCourseByIdService;

    val findAllCoursesService;

    val findCourseByAcademicLevelService;

    val findCourseByFacultyService;

    val findCourseByIdService;

    val findCourseByModalityService;

    val findCourseByNameService;

    val findCourseByUserService;

    val updateCourseService;

    public Optional<CourseDto> saveCourse(Course course) {
        return ((SaveCourseService) saveCourseService).save(course);
    }

    public void deleteCourse(Course course) {
        ((DeleteCoursesService) deleteCoursesService).delete(course);
    }

    public void deleteCourseById(Long id) {
        ((DeleteCourseByIdService) deleteCourseByIdService).deleteById(id);
    }

    public Set<CourseDto> findAllCourses() {
        return ((FindAllCoursesService) findAllCoursesService).findAll();
    }

    public List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel) {
        return ((FindCourseByAcademicLevelService) findCourseByAcademicLevelService).findByAcademicLevel(academicLevel);
    }

    public List<CourseDto> findByFaculty(Faculty faculty) {
        return ((FindCourseByFacultyService) findCourseByFacultyService).findByFaculty(faculty);
    }

    public Optional<CourseDto> findById(Long id) {
        return ((FindCourseByIdService) findCourseByIdService).findById(id);
    }

    public List<CourseDto> findByModality(Modality modality) {
        return ((FindCourseByModalityService) findCourseByModalityService).findByModality(modality);
    }

    public List<CourseDto> findByName(String name) {
        return ((FindCourseByNameService) findCourseByNameService).findByName(name);
    }

    public List<CourseDto> findByUser(String userId) {
        return ((FindCourseByUserService) findCourseByUserService).findByUser(userId);
    }

    public Optional<CourseDto> update(Long id, Course course) {
        return ((UpdateCourseService) updateCourseService).update(id, course);
    }


}
