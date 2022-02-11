package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
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
        User user = User.builder()
                .id("123")
                .firstName("User")
                .lastName("Last Name")
                .build();
        when(userRepository.findById("123")).thenReturn(Optional.of(user));
        User user2 = new User();
        user2.setId("123");
        deleteUserService.delete(user2);
        verify(userRepository).delete(user2);
    }
    @Test
    void delete_WithThrowsException() {

        assertThrows(NullEntityException.class, () -> {
            User user = new User();
            user.setId("1234");
            deleteUserService.delete(user);
        });
    }
}