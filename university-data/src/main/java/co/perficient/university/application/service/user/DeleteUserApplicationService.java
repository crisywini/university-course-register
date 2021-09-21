package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.service.user.DeleteUserService;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserApplicationService {
    private final DeleteUserService deleteUserService;

    public DeleteUserApplicationService(DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    public void run(User user) {
        deleteUserService.delete(user);
    }
}
