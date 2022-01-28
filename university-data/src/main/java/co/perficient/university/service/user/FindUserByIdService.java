package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService {

    private final UserRepository userService;

    public FindUserByIdService(UserRepository userService) {
        this.userService = userService;
    }

    public Optional<User> findById(String id) {
        return userService.findById(id);
    }
}
