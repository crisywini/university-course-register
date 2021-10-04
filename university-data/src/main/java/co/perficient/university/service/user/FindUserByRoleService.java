package co.perficient.university.service.user;

import co.perficient.university.model.Role;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserByRoleService {
    private final UserRepository userRepository;

    public FindUserByRoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findByRole(Role role) {
        return userRepository.findByRole(role);
    }
}
