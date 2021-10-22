package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseSubject implements Serializable, BaseEntity<CourseSubject> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Lob
    @Column(nullable = false)
    private String syllabus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Course course;

    @Column(name = "academic_credits", nullable = false)
    private int academicCredits;

    @Enumerated
    @Column(nullable = false)
    private Methodology methodology;


    @Override
    public CourseSubject updateWith(CourseSubject newItem) {

        return new CourseSubject(this.getId(),
                newItem.getName(),
                newItem.getDescription(),
                newItem.getSyllabus(),
                newItem.getCourse(),
                newItem.getAcademicCredits(),
                newItem.getMethodology());
    }
}
