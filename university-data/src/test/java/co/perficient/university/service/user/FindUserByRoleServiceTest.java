package co.perficient.university.service.user;

import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.model.Role;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserByRoleServiceTest {

    @Mock
    private UserRepository userRepository;
    private FindUserByRoleService findUserByRoleService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findUserByRoleService = new FindUserByRoleService(userRepository);
    }

    @Test
    void findByRole() {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("1", "manager@email.com", "Lina", "Jaramillo"));
        when(userRepository.findByRole(Role.MANAGER)).thenReturn(users);
        UserDto expected = new UserDto("1", "manager@email.com", "Lina", "Jaramillo");
        List<UserDto> usersRequested = findUserByRoleService.findByRole(Role.MANAGER);
        assertThat(usersRequested).containsExactly(expected);
    }

    @Test
    void findByRole_WithExceptionThrows() {
        assertThrows(ParamNotFoundException.class, () -> {
            List<UserDto> users = findUserByRoleService.findByRole(Role.n);
        });
    }
}