package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.service.user.SaveUserService;
import org.springframework.stereotype.Service;

@Service
public class SaveUserApplicationService {
    private final SaveUserService saveUserService;

    public SaveUserApplicationService(SaveUserService saveUserService) {
        this.saveUserService = saveUserService;
    }

    public User run(User user) {
        return saveUserService.save(user);
    }
}
