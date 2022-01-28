package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.*;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseSubjectApplicationService {

    val deleteCourseSubjectService;

    val deleteCourseSubjectByIdService;

    val findAllCourseSubjectsService;

    val findCourseSubjectByCourseService;

    val findCourseSubjectByIdService;

    val findCourseSubjectByMethodologyService;

    val findCourseSubjectByNameService;

    val saveCourseSubjectService;

    val updateCourseSubjectService;

    public Optional<CourseSubjectDto> save(CourseSubject courseSubject) {
        return ((SaveCourseSubjectService) saveCourseSubjectService).save(courseSubject);
    }

    public void delete(CourseSubject courseSubject) {
        ((DeleteCourseSubjectService) deleteCourseSubjectService).delete(courseSubject);
    }

    public void deleteById(Long id) {
        ((DeleteCourseSubjectByIdService) deleteCourseSubjectByIdService).deleteById(id);
    }

    public Set<CourseSubjectDto> findAll() {
        return ((FindAllCourseSubjectsService) findAllCourseSubjectsService).findAll();
    }

    public List<CourseSubjectDto> findByCourse(Long courseId) {
        return ((FindCourseSubjectByCourseService) findCourseSubjectByCourseService).findByCourse(courseId);
    }

    public Optional<CourseSubjectDto> findById(Long id) {
        return ((FindCourseSubjectByIdService) findCourseSubjectByIdService).findById(id);
    }

    public List<CourseSubjectDto> findByMethodology(Methodology methodology) {
        return ((FindCourseSubjectByMethodologyService) findCourseSubjectByMethodologyService).findByMethodology(
                methodology);
    }

    public List<CourseSubjectDto> findByName(String name) {
        return ((FindCourseSubjectByNameService) findCourseSubjectByNameService).findByName(name);
    }

    public Optional<CourseSubjectDto> update(Long id, CourseSubject courseSubject) {
        return ((UpdateCourseSubjectService) updateCourseSubjectService).update(id, courseSubject);
    }

}
