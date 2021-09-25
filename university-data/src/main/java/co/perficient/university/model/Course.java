package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course extends BaseEntity<Course> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Enumerated
    @Column(name = "academic_level", nullable = false)
    private AcademicLevel academicLevel;

    @Enumerated
    @Column(nullable = false)
    private Faculty faculty;

    @Enumerated
    @Column(nullable = false)
    private Modality modality;

    @Column(name = "total_academic_credits", nullable = false)
    private int totalAcademicCredits;


    @Column(name = "course_subjects")
    @OneToMany(mappedBy = "course")
    private Set<CourseSubject> courseSubjects;


    public Course(String name, String title, AcademicLevel academicLevel,
                  Faculty faculty, Modality modality, int totalAcademicCredits) {
        this.name = name;
        this.title = title;
        this.academicLevel = academicLevel;
        this.faculty = faculty;
        this.modality = modality;
        this.totalAcademicCredits = totalAcademicCredits;
    }

    @Override
    public Course updateWith(Course newItem) {

        return new Course(this.getId(),
                newItem.getName(),
                newItem.getTitle(),
                newItem.getAcademicLevel(),
                newItem.getFaculty(),
                newItem.getModality(),
                newItem.getTotalAcademicCredits(),
                newItem.getCourseSubjects());
    }

}
