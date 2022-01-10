package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseSubjectJPARepository;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
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
    public Set<CourseSubjectDto> findAll() {
        return courseSubjectJPARepository
                .findAll()
                .stream()
                .map(x -> new CourseSubjectDto(x.getId(),
                        x.getDescription(),
                        x.getName(),
                        x.getMethodology()))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<CourseSubjectDto> findById(Long id) {
        return courseSubjectJPARepository.findById(id)
                .map(c -> CourseSubjectDto.builder()
                        .id(c.getId())
                        .description(c.getDescription())
                        .name(c.getName())
                        .methodology(c.getMethodology())
                        .build());
    }

    @Override
    public Optional<CourseSubjectDto> save(CourseSubject object) {
        return Optional.of(courseSubjectJPARepository.save(object)).map(c -> CourseSubjectDto.builder()
                .id(c.getId())
                .description(c.getDescription())
                .name(c.getName())
                .methodology(c.getMethodology())
                .build());
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
    public Optional<CourseSubjectDto> update(Long id, CourseSubject newEntity) {
        return courseSubjectJPARepository.findById(id).map(subject -> {
            CourseSubject c = courseSubjectJPARepository.save(subject.updateWith(newEntity));
            return CourseSubjectDto.builder()
                    .id(c.getId())
                    .description(c.getDescription())
                    .name(c.getName())
                    .methodology(c.getMethodology())
                    .build();
        });
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
