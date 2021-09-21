package co.perficient.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated
    private Gender gender;

    @Enumerated
    private Nationality nationality;

    @Column(name = "marital_status")
    @Enumerated
    private MaritalStatus maritalStatus;

    @ManyToMany(mappedBy = "users")
    @Column(name = "course_subjects", unique = true)
    private List<CourseSubject> courseSubjects;

    public User(String firstName, String lastName, String email, LocalDate dateOfBirth,
                Gender gender, Nationality nationality, MaritalStatus maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
    }

}
