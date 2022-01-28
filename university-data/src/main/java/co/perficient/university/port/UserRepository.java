package co.perficient.university.port;

import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {
    List<UserDto> findByRole(Role role);
    List<UserDto> findByFirstName(String name);
    Optional<User> findByEmail(String email);
}
