package co.perficient.university.service.user;

import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.model.mapper.UserMapper;
import co.perficient.university.port.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllUsersServiceTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mock
    private UserRepository userRepository;
    private FindAllUsersService findAllUsersService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        findAllUsersService = new FindAllUsersService(userRepository);
        Set<User> users = new HashSet<>();
        users.add(Optional.of(new UserDto("1","1email@gmail.com","User","last name")).map(userMapper::userDtoToUser).get());
        users.add(Optional.of(new UserDto("2","2email@gmail.com","User","last name")).map(userMapper::userDtoToUser).get());
        users.add(Optional.of(new UserDto("3","3email@gmail.com","User","last name")).map(userMapper::userDtoToUser).get());
        users.add(Optional.of(new UserDto("4","4email@gmail.com","User","last name")).map(userMapper::userDtoToUser).get());
        when(userRepository.findAll())
                .thenReturn(users);
    }


    @Test
    void findAll() {
        Set<User> all = findAllUsersService.findAll();
        assertThat(all).allMatch(user -> user.getEmail().contains("gmail.com"));
        verify(userRepository).findAll();
    }
}