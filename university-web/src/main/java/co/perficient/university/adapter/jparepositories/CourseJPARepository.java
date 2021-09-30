package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseJPARepository extends JpaRepository<Course, Long> {
    @Query("SELECT new co.perficient.university.model.dto.CourseDto(c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality) \n" +
            "FROM Course c WHERE c.name = :name")
    List<CourseDto> findByName(@Param("name") String name);

    @Query("SELECT new co.perficient.university.model.dto.CourseDto(c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality) \n" +
            "FROM Course c WHERE c.userCreator.id = :userId")
    List<CourseDto> findByUser(@Param("userId") String userId);

    @Query("SELECT new co.perficient.university.model.dto.CourseDto(c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality) \n" +
            "FROM Course c WHERE c.faculty = :faculty")
    List<CourseDto> findByFaculty(@Param("faculty") Faculty faculty);

    @Query("SELECT new co.perficient.university.model.dto.CourseDto(c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality) \n" +
            "FROM Course c WHERE c.academicLevel = :academicLevel")
    List<CourseDto> findByAcademicLevel(@Param("academicLevel") AcademicLevel academicLevel);

    @Query("SELECT new co.perficient.university.model.dto.CourseDto(c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality) \n" +
            "FROM Course c WHERE c.modality = :modality")
    List<CourseDto> findByModality(@Param("modality") Modality modality);
}
