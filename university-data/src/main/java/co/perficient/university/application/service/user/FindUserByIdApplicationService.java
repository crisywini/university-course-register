package co.perficient.university.application.service.user;

import co.perficient.university.model.User;
import co.perficient.university.service.user.FindUserByIdService;

public class FindUserByIdApplicationService {

    private final FindUserByIdService findUserByIdService;

    public FindUserByIdApplicationService(FindUserByIdService findUserByIdService) {
        this.findUserByIdService = findUserByIdService;
    }

    public User run(String id) {
        return findUserByIdService.findById(id);
    }
}