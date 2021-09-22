package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.service.user.FindAllUsersService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllUsersApplicationService {

    private final FindAllUsersService findAllUsersService;

    public FindAllUsersApplicationService(FindAllUsersService findAllUsersService) {
        this.findAllUsersService = findAllUsersService;
    }

    public Set<User> run() {
        return findAllUsersService.findAll();
    }
}