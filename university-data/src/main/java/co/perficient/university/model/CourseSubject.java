package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "teacher_name")
    //private String teacherName;
    private String description;
    @Lob
    private String syllabus;
    private int quota;
    @Column(name = "pensum_code")
    private int pensumCode;
    /*@Column(name = "academic_program_code")
    private int academicProgramCode;*/
    @Column(name = "group_course")
    private String group;
    @ManyToOne
    private Course course;
    @ManyToMany
    private List<User> users;
    @OneToOne
    private Schedule schedule;


}
