package co.perficient.university.application.service.user;

import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.service.user.*;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    val deleteUserByIdService;

    val deleteUserService;

    val findAllUsersService;

    val findUserByEmailService;

    val findUserByFirstNameService;

    val findUserByIdService;

    val findUserByRoleService;

    val saveUserService;

    val updateUserService;

    public Optional<User> save(User user) {
        return ((SaveUserService) saveUserService).save(user);
    }

    public void delete(User user) {
        ((DeleteUserService) deleteUserService).delete(user);
    }

    public void deleteById(String id) {
        ((DeleteUserByIdService) deleteUserByIdService).deleteById(id);
    }

    public Set<User> findAll() {
        return ((FindAllUsersService) findAllUsersService).findAll();
    }

    public Optional<User> findByEmail(String email) {
        return ((FindUserByEmailService) findUserByEmailService).findByEmail(email);
    }

    public List<UserDto> findByFirstName(String name) {
        return ((FindUserByFirstNameService) findUserByFirstNameService).findByFirstName(name);
    }

    public Optional<User> findById(String id) {
        return ((FindUserByIdService) findUserByIdService).findById(id);
    }

    public List<UserDto> findByRole(Role role) {
        return ((FindUserByRoleService) findUserByRoleService).findByRole(role);
    }

    public Optional<User> update(String id, User user) {
        return ((UpdateUserService) updateUserService).update(id, user);
    }


}
