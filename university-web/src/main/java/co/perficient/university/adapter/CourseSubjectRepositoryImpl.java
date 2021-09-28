package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseSubjectJPARepository;
import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseSubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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
                        x.getQuota()))
                .collect(Collectors.toSet());
    }

    @Override
    public CourseSubjectDto findById(Long id) {
        CourseSubject courseSubject = courseSubjectJPARepository.findById(id).orElse(null);
        return new CourseSubjectDto(courseSubject.getId(),
                courseSubject.getDescription(),
                courseSubject.getName(),
                courseSubject.getQuota());
    }

    @Override
    public CourseSubjectDto save(CourseSubject object) {
        CourseSubject courseSubject = courseSubjectJPARepository.save(object);
        return new CourseSubjectDto(courseSubject.getId(),
                courseSubject.getDescription(),
                courseSubject.getName(),
                courseSubject.getQuota());
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
    public CourseSubjectDto update(Long id, CourseSubject newEntity) {
        CourseSubject courseSubject = courseSubjectJPARepository.findById(id).get();
        CourseSubject updatedCourseSubject = courseSubjectJPARepository.save(courseSubject.updateWith(newEntity));
        return new CourseSubjectDto(updatedCourseSubject.getId(),
                updatedCourseSubject.getDescription(),
                updatedCourseSubject.getName(),
                updatedCourseSubject.getQuota());
    }
}
