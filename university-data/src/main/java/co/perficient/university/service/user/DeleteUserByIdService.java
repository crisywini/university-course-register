package co.perficient.university.service.user;

import co.perficient.university.port.ScheduleService;
import co.perficient.university.port.UserService;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserByIdService {

    private final UserService userService;
    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public DeleteUserByIdService(UserService userService) {
        this.userService = userService;
    }

    public void deleteById(String id) {
        validateExisting(id);
        userService.deleteById(id);
    }

    private void validateExisting(String id) {
        if (userService.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
