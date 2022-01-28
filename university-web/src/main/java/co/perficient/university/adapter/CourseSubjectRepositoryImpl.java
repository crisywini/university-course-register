package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseSubjectJPARepository;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import java.util.HashSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CourseSubjectRepositoryImpl implements CourseSubjectRepository {

    private final CourseSubjectJPARepository courseSubjectJPARepository;

    public CourseSubjectRepositoryImpl(CourseSubjectJPARepository courseSubjectJPARepository) {
        this.courseSubjectJPARepository = courseSubjectJPARepository;
    }

    @Override
    public Set<CourseSubject> findAll() {
        return new HashSet<>(courseSubjectJPARepository
                .findAll());
    }

    @Override
    public Optional<CourseSubject> findById(Long id) {
        return courseSubjectJPARepository.findById(id);
    }

    @Override
    public Optional<CourseSubject> save(CourseSubject object) {
        return Optional.of(courseSubjectJPARepository.save(object));
    }

    @Override
    public void delete(CourseSubject object) {
        courseSubjectJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        courseSubjectJPARepository.deleteById(id);
    }

    @Override
    public Optional<CourseSubject> update(Long id, CourseSubject newEntity) {
        return courseSubjectJPARepository.findById(id)
                .map(subject -> courseSubjectJPARepository.save(subject.updateWith(newEntity)));
    }

    @Override
    public List<CourseSubjectDto> findByName(String name) {
        return courseSubjectJPARepository.findByName(name);
    }

    @Override
    public List<CourseSubjectDto> findByCourse(Long courseId) {
        return courseSubjectJPARepository.findByCourse(courseId);
    }

    @Override
    public List<CourseSubjectDto> findByMethodology(Methodology methodology) {
        return courseSubjectJPARepository.findByMethodology(methodology);
    }

}
