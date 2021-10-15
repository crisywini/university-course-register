package co.perficient.university.service.user;

import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserByIdServiceTest {

    @Mock
    private UserRepository userRepository;
    private FindUserByIdService findUserByIdService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findUserByIdService = new FindUserByIdService(userRepository);
        UserDto userDto = new UserDto();
        userDto.setId("1234");
        when(userRepository.findById("1234"))
                .thenReturn(userDto);
    }

    @Test
    void findById() {
        UserDto expected = new UserDto();
        expected.setId("1234");
        UserDto userDto = findUserByIdService.findById("1234");
        assertThat(userDto.getId()).isEqualTo(expected.getId());
        verify(userRepository).findById("1234");
    }
}