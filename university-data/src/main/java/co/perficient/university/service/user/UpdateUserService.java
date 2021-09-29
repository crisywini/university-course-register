package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {
    private final UserRepository userRepository;
    private final String NON_EXISTING_USER_MESSAGE = "The user cannot be updated because does not exists!";

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto update(String id, User newUser) {
        validateExistingUser(id);
        return userRepository.update(id, newUser);
    }

    private void validateExistingUser(String id) {
        if (userRepository.findById(id) == null) {
            throw new RuntimeException(NON_EXISTING_USER_MESSAGE);
        }
    }
}
