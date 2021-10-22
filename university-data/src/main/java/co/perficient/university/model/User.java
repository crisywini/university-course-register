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
@Entity(name = "user_manager")
public class User implements Serializable, BaseEntity<User> {

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

    @Enumerated
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "userCreator")
    private List<Course> courses;


    @Override
    public User updateWith(User newItem) {

        return new User(this.id,
                newItem.getFirstName(),
                newItem.getLastName(),
                newItem.getEmail(),
                newItem.getPassword(),
                newItem.getRole(),
                newItem.getCourses());
    }
}
