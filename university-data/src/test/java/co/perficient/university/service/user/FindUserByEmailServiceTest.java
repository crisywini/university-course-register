package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserByEmailServiceTest {

    @Mock
    private UserRepository userRepository;
    private FindUserByEmailService findUserByEmailService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findUserByEmailService = new FindUserByEmailService(userRepository);
        User user = new User();
        user.setEmail("2email@gmail.com");
        when(userRepository.findByEmail("2email@gmail.com"))
                .thenReturn(Optional.of(user));

    }

    @Test
    void findByEmail() {
        User expected = new User();
        expected.setEmail("2email@gmail.com");
        User requested = findUserByEmailService.findByEmail("2email@gmail.com").get();
        assertThat(requested.getEmail()).isEqualTo(expected.getEmail());
    }
}