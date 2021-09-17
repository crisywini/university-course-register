package co.perficient.university.service.user;

import co.perficient.university.model.Schedule;
import co.perficient.university.model.User;
import co.perficient.university.port.ScheduleService;
import co.perficient.university.port.UserService;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    private final UserService userService;
    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public DeleteUserService(UserService userService) {
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
