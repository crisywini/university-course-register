package co.perficient.university.service.user;


import co.perficient.university.model.Schedule;
import co.perficient.university.model.User;
import co.perficient.university.port.ScheduleService;
import co.perficient.university.port.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllUsersService {

    private final UserService userService;

    public FindAllUsersService(UserService userService) {
        this.userService = userService;
    }

    public Set<User> findAll() {
        return userService.findAll();
    }


}
