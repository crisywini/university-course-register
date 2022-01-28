package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteUserByIdService {

    private final UserRepository userService;

    private static final String NON_EXISTING_USER_MESSAGE = "The user does not exists!";

    public DeleteUserByIdService(UserRepository userService) {
        this.userService = userService;
    }

    public void deleteById(String id) {
        userService.deleteById(getIdIfUserExists(id));
    }

    private String getIdIfUserExists(String id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new NullEntityException(NON_EXISTING_USER_MESSAGE));
        return user.getId();
    }

}
