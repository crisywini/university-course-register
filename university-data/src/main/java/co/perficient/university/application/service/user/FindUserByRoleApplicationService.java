package co.perficient.university.application.service.user;

import co.perficient.university.model.Role;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.FindUserByRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserByRoleApplicationService {
    private final FindUserByRoleService findUserByRoleService;

    public FindUserByRoleApplicationService(FindUserByRoleService findUserByRoleService) {
        this.findUserByRoleService = findUserByRoleService;
    }

    public List<UserDto> run(Role role) {
        return findUserByRoleService.findByRole(role);
    }
}
