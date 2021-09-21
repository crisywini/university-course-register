package co.perficient.university.application.service.user;

import co.perficient.university.service.user.DeleteUserByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserByIdApplicationService {

    private final DeleteUserByIdService deleteUserByIdService;

    public DeleteUserByIdApplicationService(DeleteUserByIdService deleteUserByIdService) {
        this.deleteUserByIdService = deleteUserByIdService;
    }

    public void run(String id) {
        deleteUserByIdService.deleteById(id);
    }
}
