package co.perficient.university.service.user;

import co.perficient.university.model.Schedule;
import co.perficient.university.model.User;
import co.perficient.university.port.ScheduleService;
import co.perficient.university.port.UserService;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService {

    private final UserService userService;

    public FindUserByIdService(UserService userService) {
        this.userService = userService;
    }

    public User findById(String id) {
        return userService.findById(id);
    }
}
