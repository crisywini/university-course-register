package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
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
        validateExistingUser(user);
        userService.delete(user);
    }

    private void validateExistingUser(User user) {
        if (userService.findById(user.getId()).isEmpty()) {
            throw new NullEntityException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
