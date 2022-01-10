package co.perficient.university.application.service.coursesubject;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.service.coursesubject.*;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseSubjectApplicationService {
    private final DeleteCourseSubjectService deleteCourseSubjectService;
    private final DeleteCourseSubjectByIdService deleteCourseSubjectByIdService;
    private final FindAllCourseSubjectsService findAllCourseSubjectsService;
    private final FindCourseSubjectByCourseService findCourseSubjectByCourseService;
    private final FindCourseSubjectByIdService findCourseSubjectByIdService;
    private final FindCourseSubjectByMethodologyService findCourseSubjectByMethodologyService;
    private final FindCourseSubjectByNameService findCourseSubjectByNameService;
    private final SaveCourseSubjectService saveCourseSubjectService;
    private final UpdateCourseSubjectService updateCourseSubjectService;

    public Optional<CourseSubjectDto> save(CourseSubject courseSubject) {
        return saveCourseSubjectService.save(courseSubject);
    }

    public void delete(CourseSubject courseSubject) {
        deleteCourseSubjectService.delete(courseSubject);
    }

    public void deleteById(Long id) {
        deleteCourseSubjectByIdService.deleteById(id);
    }

    public Set<CourseSubjectDto> findAll() {
        return findAllCourseSubjectsService.findAll();
    }

    public List<CourseSubjectDto> findByCourse(Long courseId) {
        return findCourseSubjectByCourseService.findByCourse(courseId);
    }

    public Optional<CourseSubjectDto> findById(Long id) {
        return findCourseSubjectByIdService.findById(id);
    }

    public List<CourseSubjectDto> findByMethodology(Methodology methodology) {
        return findCourseSubjectByMethodologyService.findByMethodology(methodology);
    }

    public List<CourseSubjectDto> findByName(String name) {
        return findCourseSubjectByNameService.findByName(name);
    }

    public Optional<CourseSubjectDto> update(Long id, CourseSubject courseSubject) {
        return updateCourseSubjectService.update(id, courseSubject);
    }
}
