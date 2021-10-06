package co.perficient.university.application.service.user;

import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    private final DeleteUserByIdService deleteUserByIdService;
    private final DeleteUserService deleteUserService;
    private final FindAllUsersService findAllUsersService;
    private final FindUserByEmailService findUserByEmailService;
    private final FindUserByFirstNameService findUserByFirstNameService;
    private final FindUserByIdService findUserByIdService;
    private final FindUserByRoleService findUserByRoleService;
    private final SaveUserService saveUserService;
    private final UpdateUserService updateUserService;

    public UserDto save(User user) {
        return saveUserService.save(user);
    }

    public void delete(User user) {
        deleteUserService.delete(user);
    }

    public void deleteById(String id) {
        deleteUserByIdService.deleteById(id);
    }

    public Set<UserDto> findAll() {
        return findAllUsersService.findAll();
    }

    public User findByEmail(String email) {
        return findUserByEmailService.findByEmail(email);
    }

    public List<UserDto> findByFirstName(String name) {
        return findUserByFirstNameService.findByFirstName(name);
    }

    public UserDto findById(String id) {
        return findUserByIdService.findById(id);
    }

    public List<UserDto> findByRole(Role role) {
        return findUserByRoleService.findByRole(role);
    }

    public UserDto update(String id, User user) {
        return updateUserService.update(id, user);
    }


}
