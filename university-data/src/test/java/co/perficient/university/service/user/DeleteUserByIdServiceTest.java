package co.perficient.university.service.user;

import co.perficient.university.exception.NullEntityException;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.junit.jupiter.api.AfterEach;
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
        UserDto userDto = new UserDto();
        userDto.setId("123");
        userDto.setFirstName("User");
        userDto.setLastName("Last Name");
        when(userRepository.findById("123"))
                .thenReturn(userDto);

        deleteUserByIdService.deleteById("123");
        verify(userRepository).deleteById("123");
    }

    @Test
    void deleteById_AndThrowsException() {

        assertThrows(NullEntityException.class, ()-> deleteUserByIdService.deleteById("3"));
    }

}