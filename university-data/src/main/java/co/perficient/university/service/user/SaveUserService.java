package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveUserService {

    private final UserRepository userService;

    private static final String USER_REPEATED_MESSAGE = "The user already exists!";

    public SaveUserService(UserRepository userService) {
        this.userService = userService;
    }

    public User save(User user) {
        validateNonRepeated(user);
        return userService.save(user);
    }

    private void validateNonRepeated(User user) {
        if (userService.findById(user.getId()) != null) {
            throw new RuntimeException(USER_REPEATED_MESSAGE);
        }
    }

}
