package co.perficient.university.model.mapper;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
