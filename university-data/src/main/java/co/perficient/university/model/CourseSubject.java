package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseSubject extends BaseEntity<CourseSubject> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String description;
    @Lob
    private String syllabus;
    private int quota;
    @Column(name = "pensum_code")
    private int pensumCode;
    @Column(name = "group_course")
    private String group;
    @ManyToOne
    private Course course;
    @ManyToMany
    private List<User> users;
    @OneToOne
    private Schedule schedule;

    @Override
    public CourseSubject updateWith(CourseSubject newItem) {

        return new CourseSubject(this.getId(),
                newItem.getName(),
                newItem.getDescription(),
                newItem.getSyllabus(),
                newItem.getQuota(),
                newItem.getPensumCode(),
                newItem.getGroup(),
                newItem.getCourse(),
                newItem.getUsers(),
                newItem.getSchedule());
    }
}
