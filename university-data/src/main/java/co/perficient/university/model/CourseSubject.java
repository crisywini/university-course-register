package co.perficient.university.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


@Entity
public class CourseSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String teacherName;
    private String description;
    private String syllabus;
    private int quota;
    private int pensumCode;
    private int academicProgramCode;
    private String group;
    private Course course;
    private List<User> users;

    public CourseSubject() {
    }

    public CourseSubject(String teacherName, String description, String syllabus, int quota,
                         int pensumCode, int academicProgramCode, String group, Course course) {
        this.teacherName = teacherName;
        this.description = description;
        this.syllabus = syllabus;
        this.quota = quota;
        this.pensumCode = pensumCode;
        this.academicProgramCode = academicProgramCode;
        this.group = group;
        this.course = course;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getPensumCode() {
        return pensumCode;
    }

    public void setPensumCode(int pensumCode) {
        this.pensumCode = pensumCode;
    }

    public int getAcademicProgramCode() {
        return academicProgramCode;
    }

    public void setAcademicProgramCode(int academicProgramCode) {
        this.academicProgramCode = academicProgramCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}