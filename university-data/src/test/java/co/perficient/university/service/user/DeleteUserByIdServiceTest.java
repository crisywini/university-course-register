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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteUserByIdServiceTest {

    @Mock
    private UserRepository userRepository;

    private DeleteUserByIdService deleteUserByIdService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        deleteUserByIdService = new DeleteUserByIdService(userRepository);
    }

    @Test
    void deleteById() {
        User user = User.builder()
                .id("123")
                .firstName("User")
                .lastName("Last Name")
                .build();
        when(userRepository.findById("123"))
                .thenReturn(Optional.of(user));

        deleteUserByIdService.deleteById("123");
        verify(userRepository).deleteById("123");
    }

    @Test
    void deleteById_AndThrowsException() {

        assertThrows(NullEntityException.class, ()-> deleteUserByIdService.deleteById("3"));
    }

}