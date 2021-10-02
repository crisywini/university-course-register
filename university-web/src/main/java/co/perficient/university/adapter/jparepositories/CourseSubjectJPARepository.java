package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.Methodology;
import co.perficient.university.model.dto.CourseSubjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseSubjectJPARepository extends JpaRepository<CourseSubject, Long> {

    @Query("SELECT new co.perficient.university.model.dto.CourseSubjectDto(cs.id, cs.description, cs.name, cs.methodology) " +
            "FROM CourseSubject cs WHERE cs.name = :name")
    List<CourseSubjectDto> findByName(@Param("name") String name);
    @Query("SELECT new co.perficient.university.model.dto.CourseSubjectDto(cs.id, cs.description, cs.name, cs.methodology) " +
            "FROM CourseSubject cs WHERE cs.course.id = :courseId")
    List<CourseSubjectDto> findByCourse(@Param("courseId") Long courseId);
    @Query("SELECT new co.perficient.university.model.dto.CourseSubjectDto(cs.id, cs.description, cs.name, cs.methodology) " +
            "FROM CourseSubject cs WHERE cs.methodology = :methodology")
    List<CourseSubjectDto> findByMethodology(@Param("methodology")Methodology methodology);
}
