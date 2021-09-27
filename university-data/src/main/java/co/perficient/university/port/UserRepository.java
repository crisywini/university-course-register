package co.perficient.university.port;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, String> {
    Set<UserDto> findAll();

    UserDto update(String id, User newEntity);
}
