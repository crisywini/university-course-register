package co.perficient.university.port;

import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;

import java.util.List;


public interface UserRepository extends CrudRepository<User, UserDto, String> {
    List<UserDto> findByRole(Role role);
    List<UserDto> findByFirstName(String name);
    User findByEmail(String email);
}
