package co.perficient.university.service.user;


import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllUsersService {

    private final UserRepository userService;

    public FindAllUsersService(UserRepository userService) {
        this.userService = userService;
    }

    public Set<User> findAll() {
        return userService.findAll();
    }
}
