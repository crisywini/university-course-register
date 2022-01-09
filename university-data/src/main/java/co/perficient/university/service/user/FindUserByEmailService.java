package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailService {
    private final UserRepository userRepository;

    public FindUserByEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
