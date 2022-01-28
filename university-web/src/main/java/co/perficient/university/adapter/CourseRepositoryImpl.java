package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJPARepository courseJPARepository;

    public CourseRepositoryImpl(CourseJPARepository courseJPARepository) {
        this.courseJPARepository = courseJPARepository;
    }


    @Override
    public Set<Course> findAll() {
        return new HashSet<>(courseJPARepository.findAll());
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseJPARepository.findById(id);
    }

    @Override
    public Optional<Course> save(Course object) {
        return Optional.of(courseJPARepository.save(object));
    }

    @Override
    public void delete(Course object) {
        courseJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        courseJPARepository.deleteById(id);
    }

    @Override
    public Optional<Course> update(Long id, Course newEntity) {
        Course course = courseJPARepository.findById(id).orElse(new Course());
        return Optional.of(courseJPARepository.save(course.updateWith(newEntity)));
    }

    @Override
    public Optional<CourseSubjectDto> addCourseSubject(Long courseId, CourseSubject courseSubject) {
        return null;
    }

    @Override
    public List<CourseDto> findByName(String name) {
        return courseJPARepository.findByName(name);
    }

    @Override
    public List<CourseDto> findByUser(String userId) {
        return courseJPARepository.findByUser(userId);
    }

    @Override
    public List<CourseDto> findByFaculty(Faculty faculty) {
        return courseJPARepository.findByFaculty(faculty);
    }

    @Override
    public List<CourseDto> findByAcademicLevel(AcademicLevel academicLevel) {
        return courseJPARepository.findByAcademicLevel(academicLevel);
    }

    @Override
    public List<CourseDto> findByModality(Modality modality) {
        return courseJPARepository.findByModality(modality);
    }

}
