package co.perficient.university.adapter.jparepositories;

import co.perficient.university.model.AcademicLevel;
import co.perficient.university.model.Course;
import co.perficient.university.model.Faculty;
import co.perficient.university.model.Modality;
import co.perficient.university.model.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseJPARepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality \n" +
            "FROM course c WHERE c.name = :name")
    List<CourseDto> findByName(@Param("name") String name);

    @Query("SELECT c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality \n" +
            "FROM course c WHERE c.user_creator_id = :user_id")
    List<CourseDto> findByUser(@Param("user_id") String userId);

    @Query("SELECT c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality \n" +
            "FROM course c WHERE c.faculty = :faculty")
    List<CourseDto> findByFaculty(@Param("faculty") Faculty faculty);

    @Query("SELECT c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality \n" +
            "FROM course c WHERE c.academic_level = :academic_level")
    List<CourseDto> findByAcademicLevel(@Param("academic_level") AcademicLevel academicLevel);

    @Query("SELECT c.id, c.name, c.title, c.academicLevel, c.faculty, c.modality \n" +
            "FROM course c WHERE c.modality = :modality")
    List<CourseDto> findByModality(Modality modality);


}
