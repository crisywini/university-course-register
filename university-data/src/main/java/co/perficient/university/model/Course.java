package co.perficient.university.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "course_subjects")
    @OneToMany(mappedBy = "course")
    private Set<CourseSubject> courseSubjects;

    public Course() {
    }

    public Course(String name, Set<CourseSubject> courseSubjects) {
        this.name = name;
        this.courseSubjects = courseSubjects;
    }

    public Set<CourseSubject> getCourseSubjects() {
        return courseSubjects;
    }

    public void setCourseSubjects(Set<CourseSubject> courseSubjects) {
        this.courseSubjects = courseSubjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
