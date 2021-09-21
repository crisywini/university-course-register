package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    private final UserRepository userService;
    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public DeleteUserService(UserRepository userService) {
        this.userService = userService;
    }

    public void delete(User user) {
        validateExisting(user);
        userService.delete(user);
    }

    private void validateExisting(User user) {
        if (userService.findById(user.getId()) == null) {
            throw new RuntimeException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
