package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.FindUserByIdService;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdApplicationService {

    private final FindUserByIdService findUserByIdService;

    public FindUserByIdApplicationService(FindUserByIdService findUserByIdService) {
        this.findUserByIdService = findUserByIdService;
    }

    public UserDto run(String id) {
        return findUserByIdService.findById(id);
    }
}
