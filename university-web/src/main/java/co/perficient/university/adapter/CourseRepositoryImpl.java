package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.model.Course;
import co.perficient.university.model.dto.CourseDto;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Repository;

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
    public CourseDto findById(Long id) {
        Course course = courseJPARepository.findById(id).orElse(null);
        return (course != null) ? new CourseDto(course.getId(),
                course.getName(),
                course.getTitle(),
                course.getAcademicLevel(),
                course.getFaculty(),
                course.getModality()) : null;
    }

    @Override
    public CourseDto save(Course object) {
        Course course = courseJPARepository.save(object);
        return new CourseDto(course.getId(),
                course.getName(),
                course.getTitle(),
                course.getAcademicLevel(),
                course.getFaculty(),
                course.getModality());
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
    public CourseDto update(Long id, Course newEntity) {
        Course course = courseJPARepository.findById(id).orElse(new Course());
        Course updatedCourse = courseJPARepository.save(course.updateWith(newEntity));
        return (updatedCourse != null) ?
                new CourseDto(updatedCourse.getId(),
                        updatedCourse.getName(),
                        updatedCourse.getTitle(),
                        updatedCourse.getAcademicLevel(),
                        updatedCourse.getFaculty(),
                        updatedCourse.getModality()) :
                new CourseDto(newEntity.getId(),
                        newEntity.getName(),
                        newEntity.getTitle(),
                        newEntity.getAcademicLevel(),
                        newEntity.getFaculty(),
                        newEntity.getModality());
    }
}
