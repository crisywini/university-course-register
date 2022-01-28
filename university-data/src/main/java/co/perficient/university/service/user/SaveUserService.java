package co.perficient.university.service.user;

import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveUserService {

    private final UserRepository userService;

    private static final String USER_REPEATED_MESSAGE = "The user already exists!";

    public SaveUserService(UserRepository userService) {
        this.userService = userService;
    }

    public Optional<User> save(User user) {
        validateNonRepeated(user);
        return userService.save(user);
    }

    private void validateNonRepeated(User user) {
        if (userService.findById(user.getId()).isPresent()) {
            throw new RepeatedEntityException(USER_REPEATED_MESSAGE);
        }
    }

}
