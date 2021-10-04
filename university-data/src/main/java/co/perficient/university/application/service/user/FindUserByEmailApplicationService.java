package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.service.user.FindUserByEmailService;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailApplicationService {
    private final FindUserByEmailService findUserByEmailService;

    public FindUserByEmailApplicationService(FindUserByEmailService findUserByEmailService) {
        this.findUserByEmailService = findUserByEmailService;
    }

    public User run(String email) {
        return findUserByEmailService.findByEmail(email);
    }
}
