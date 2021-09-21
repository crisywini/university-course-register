package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.adapter.jparepositories.CourseSubjectJPARepository;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CourseSubjectRepositoryImpl implements CourseSubjectRepository {
    private final CourseSubjectJPARepository courseSubjectJPARepository;

    public CourseSubjectRepositoryImpl(CourseSubjectJPARepository courseSubjectJPARepository) {
        this.courseSubjectJPARepository = courseSubjectJPARepository;
    }

    @Override
    public Set<CourseSubject> findAll() {
        return new HashSet<>(courseSubjectJPARepository.findAll());
    }

    @Override
    public CourseSubject findById(Long id) {
        return courseSubjectJPARepository.findById(id).orElse(new CourseSubject());
    }

    @Override
    public CourseSubject save(CourseSubject object) {
        return courseSubjectJPARepository.save(object);
    }

    @Override
    public void delete(CourseSubject object) {
        courseSubjectJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        courseSubjectJPARepository.deleteById(id);
    }
}
