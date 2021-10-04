package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailService {
    private final UserRepository userRepository;

    public FindUserByEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
