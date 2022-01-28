package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {
    private final UserRepository userRepository;
    private final String NON_EXISTING_USER_MESSAGE = "The user cannot be updated because does not exists!";

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> update(String id, User newUser) {
        validateExistingUser(id);
        return userRepository.update(id, newUser);
    }

    private void validateExistingUser(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new NullEntityException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
