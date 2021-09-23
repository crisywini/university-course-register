package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated
    @Column(nullable = false)
    private EducationLevel educationLevel;
    @Column(name = "course_subjects")
    @OneToMany(mappedBy = "course")
    private Set<CourseSubject> courseSubjects;
    //@Column(name = "qualified_registration", nullable = false)
    //private String qualifiedRegistration;
    //@Column(name = "high_quality_accreditation")
    //private String highQualityAccreditation;


    public Course(String name, String title, AcademicLevel academicLevel,
                  Faculty faculty, Modality modality, int totalAcademicCredits,
                  EducationLevel educationLevel) {
        this.name = name;
        this.title = title;
        this.academicLevel = academicLevel;
        this.faculty = faculty;
        this.modality = modality;
        this.totalAcademicCredits = totalAcademicCredits;
        this.educationLevel = educationLevel;
    }
}
