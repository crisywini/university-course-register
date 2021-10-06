package co.perficient.university.service.user;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Role;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserByRoleService {
    private final UserRepository userRepository;
    private final static String ROLE_DEFAULT_MESSAGE = "The role was not found";

    public FindUserByRoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findByRole(Role role) {
        validateNoDefaultRole(role);
        return userRepository.findByRole(role);
    }

    private void validateNoDefaultRole(Role role) {
        if (role.equals(Role.n)) {
            throw new ParamNotFoundException(ROLE_DEFAULT_MESSAGE);
        }
    }
}
