package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.model.*;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.model.dto.CourseSubjectDto;
import co.perficient.university.port.CourseRepository;
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
    public Set<CourseDto> findAll() {
        return courseJPARepository
                .findAll()
                .stream()
                .map(x -> new CourseDto(x.getId(),
                        x.getName(),
                        x.getTitle(),
                        x.getAcademicLevel(),
                        x.getFaculty(),
                        x.getModality())).collect(Collectors.toSet());
    }

    @Override
    public Optional<CourseDto> findById(Long id) {
        return courseJPARepository.findById(id).map(c -> CourseDto.builder()
                .id(c.getId())
                .name(c.getName())
                .title(c.getTitle())
                .academicLevel(c.getAcademicLevel())
                .faculty(c.getFaculty())
                .modality(c.getModality())
                .build());
    }

    @Override
    public Optional<CourseDto> save(Course object) {
        return Optional.of(courseJPARepository.save(object)).map(c -> CourseDto.builder()
                .id(c.getId())
                .name(c.getName())
                .title(c.getTitle())
                .academicLevel(c.getAcademicLevel())
                .faculty(c.getFaculty())
                .modality(c.getModality())
                .build());
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
    public Optional<CourseDto> update(Long id, Course newEntity) {
        Course course = courseJPARepository.findById(id).orElse(new Course());
        return Optional.of(courseJPARepository.save(course.updateWith(newEntity))).map(c -> CourseDto.builder()
                .id(c.getId())
                .name(c.getName())
                .title(c.getTitle())
                .academicLevel(c.getAcademicLevel())
                .faculty(c.getFaculty())
                .modality(c.getModality())
                .build());
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
