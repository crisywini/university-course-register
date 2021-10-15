package co.perficient.university.service.user;

import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveUserServiceTest {

    @Mock
    private UserRepository userRepository;
    private SaveUserService saveUserService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        saveUserService = new SaveUserService(userRepository);
    }

    void setUpScenario1() {
        User user = new User("123",
                "Pedro",
                "trees",
                "pt@gmail.com",
                "123",
                Role.VIEWER,
                new ArrayList<>());
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        when(userRepository.save(user)).thenReturn(userDto);
    }

    @Test
    void save() {
        setUpScenario1();
        User user = new User("123",
                "Pedro",
                "trees",
                "pt@gmail.com",
                "123",
                Role.VIEWER,
                new ArrayList<>());
        UserDto savedOne = saveUserService.save(user);
        UserDto expected = new UserDto();
        expected.setId(user.getId());
        expected.setFirstName(user.getFirstName());
        expected.setLastName(user.getLastName());
        expected.setEmail(user.getEmail());
        assertThat(savedOne).isEqualTo(expected);
        verify(userRepository).save(user);
    }

    void setUpScenario2(){
        User user = new User("123",
                "Pedro",
                "trees",
                "pt@gmail.com",
                "123",
                Role.VIEWER,
                new ArrayList<>());
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        when(userRepository.findById("123")).thenReturn(userDto);
    }

    @Test
    void save_WithException(){
        setUpScenario2();
        assertThrows(RepeatedEntityException.class, () ->{
            User user = new User("123",
                    "Pedro",
                    "trees",
                    "pt@gmail.com",
                    "123",
                    Role.VIEWER,
                    new ArrayList<>());
            saveUserService.save(user);
        });
    }
}