package co.perficient.university.service.user;

import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserByFirstNameService {
    private final UserRepository userRepository;

    public FindUserByFirstNameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
