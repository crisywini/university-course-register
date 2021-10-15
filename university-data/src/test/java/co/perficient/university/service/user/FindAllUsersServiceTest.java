package co.perficient.university.service.user;

import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllUsersServiceTest {

    @Mock
    private UserRepository userRepository;
    private FindAllUsersService findAllUsersService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findAllUsersService = new FindAllUsersService(userRepository);
        Set<UserDto> users = new HashSet<>();
        users.add(new UserDto("1","1email@gmail.com","User","last name"));
        users.add(new UserDto("2","2email@gmail.com","User","last name"));
        users.add(new UserDto("3","3email@gmail.com","User","last name"));
        users.add(new UserDto("4","4email@gmail.com","User","last name"));
        when(userRepository.findAll())
                .thenReturn(users);
    }

    @Test
    void findAll() {
        Set<UserDto> all = findAllUsersService.findAll();
        assertThat(all).allMatch(user -> user.getEmail().contains("gmail.com"));
        verify(userRepository).findAll();
    }
}