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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteUserServiceTest {

    @Mock
    private UserRepository userRepository;

    private DeleteUserService deleteUserService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        deleteUserService = new DeleteUserService(userRepository);
    }

    @Test
    void delete() {
        UserDto userDto = new UserDto();
        userDto.setId("123");
        userDto.setFirstName("User");
        userDto.setLastName("Last name");
        when(userRepository.findById("123")).thenReturn(Optional.of(userDto));
        User user = new User();
        user.setId("123");
        deleteUserService.delete(user);
        verify(userRepository).delete(user);
    }
    @Test
    void delete_WithThrowsException() {

        assertThrows(NullEntityException.class, () -> {
            User user = new User();
            user.setId("123");
            deleteUserService.delete(user);
        });
    }
}