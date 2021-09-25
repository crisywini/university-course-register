package co.perficient.university.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_student")
public class User extends BaseEntity<User> implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Enumerated
    private Gender gender;
    @ManyToMany(mappedBy = "users")
    @Column(name = "course_subjects", unique = true)
    private List<CourseSubject> courseSubjects;

    public User(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public User updateWith(User newItem) {

        return new User(this.id,
                newItem.getFirstName(),
                newItem.getLastName(),
                newItem.getEmail(),
                newItem.getPassword(),
                newItem.getDateOfBirth(),
                newItem.getGender(),
                newItem.getCourseSubjects());
    }
}
