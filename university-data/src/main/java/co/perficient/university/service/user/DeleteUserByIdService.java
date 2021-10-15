package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class DeleteUserByIdService {

    private final UserRepository userService;
    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public DeleteUserByIdService(UserRepository userService) {
        this.userService = userService;
    }

    public void deleteById(String id) {
        validateExisting(id);
        userService.deleteById(id);
    }

    private void validateExisting(String id) {
        if (userService.findById(id) == null) {
            throw new NullEntityException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
