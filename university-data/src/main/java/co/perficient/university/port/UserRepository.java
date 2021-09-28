package co.perficient.university.port;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;



public interface UserRepository extends CrudRepository<User, UserDto, String> {

}
