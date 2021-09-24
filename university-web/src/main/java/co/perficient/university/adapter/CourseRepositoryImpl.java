package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.CourseJPARepository;
import co.perficient.university.model.Course;
import co.perficient.university.port.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

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
    public Course findById(Long id) {
        return courseJPARepository.findById(id).orElse(null);
    }

    @Override
    public Course save(Course object) {
        return courseJPARepository.save(object);
    }

    @Override
    public void delete(Course object) {
        courseJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        courseJPARepository.deleteById(id);
    }
}
