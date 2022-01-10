package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateUserServiceTest {
    @Mock
    private UserRepository userRepository;
    private UpdateUserService updateUserService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        updateUserService = new UpdateUserService(userRepository);
    }

    private void setUpScenario1() {
        User newUser = new User();
        newUser.setId("123");
        newUser.setFirstName("Megan");
        newUser.setEmail("megan@gmail.com");

        UserDto userDto = new UserDto();
        userDto.setId(newUser.getId());
        userDto.setFirstName(newUser.getFirstName());
        userDto.setEmail(newUser.getEmail());

        when(userRepository.update("123", newUser))
                .thenReturn(Optional.of(userDto));
        when(userRepository.findById("123")).thenReturn(Optional.of(userDto));
    }

    @Test
    void update() {
        setUpScenario1();

        User newUser = new User();
        newUser.setId("123");
        newUser.setFirstName("Megan");
        newUser.setEmail("megan@gmail.com");

        UserDto expected = new UserDto();
        expected.setId("123");
        expected.setFirstName("Megan");
        expected.setEmail("megan@gmail.com");

        UserDto updated = updateUserService.update("123", newUser).get();
        assertThat(updated).isEqualTo(expected);
        verify(userRepository).update("123", newUser);
    }

    @Test
    void update_WithExceptionThrows() {
        assertThrows(NullEntityException.class, ()->updateUserService.update("123", new User()));
    }
}