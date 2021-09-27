package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.UpdateUserService;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserApplicationService {
    private final UpdateUserService updateUserService;

    public UpdateUserApplicationService(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    public UserDto run(String id, User newUser) {
        return updateUserService.update(id, newUser);
    }
}
