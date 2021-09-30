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

    @Column(name = "course_subjects")
    @OneToMany(mappedBy = "course")
    private Set<CourseSubject> courseSubjects;

    @ManyToOne
    @Column(name = "user_creator")
    private User user;

    @Enumerated
    @Column(nullable = false)
    private Modality modality;


    @Override
    public Course updateWith(Course newItem) {

        return new Course(this.getId(),
                newItem.getName(),
                newItem.getTitle(),
                newItem.getAcademicLevel(),
                newItem.getFaculty(),
                newItem.getCourseSubjects(),
                newItem.getUser(),
                newItem.getModality());
    }

}
