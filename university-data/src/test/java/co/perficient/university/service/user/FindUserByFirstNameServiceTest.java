package co.perficient.university.service.user;

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
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserByFirstNameServiceTest {

    @Mock
    private UserRepository userRepository;
    private FindUserByFirstNameService findUserByFirstNameService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findUserByFirstNameService = new FindUserByFirstNameService(userRepository);
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("1","1email@gmail.com","User","last name"));
        users.add(new UserDto("2","2email@gmail.com","Pulgarin","last name"));
        users.add(new UserDto("3","3email@gmail.com","User","last name"));
        users.add(new UserDto("4","4email@gmail.com","Alejandra","last name"));

        when(userRepository.findByFirstName("User"))
                .thenReturn(users.stream()
                        .filter(u -> u.getFirstName().contains("User"))
                        .collect(Collectors.toList()));
    }

    @Test
    void findByFirstName() {
        List<UserDto> users = findUserByFirstNameService.findByFirstName("User");
        assertThat(users).hasSize(2);
        verify(userRepository).findByFirstName("User");

    }
}