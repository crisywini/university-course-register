package co.perficient.university.application.service.user;

import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.FindUserByFirstNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserByFirstNameApplicationService {
    private final FindUserByFirstNameService findUserByFirstNameService;

    public FindUserByFirstNameApplicationService(FindUserByFirstNameService findUserByFirstNameService) {
        this.findUserByFirstNameService = findUserByFirstNameService;
    }

    public List<UserDto> run(String firstName) {
        return findUserByFirstNameService.findByFirstName(firstName);
    }
}
