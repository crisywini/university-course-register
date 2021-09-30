package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.UserJPARepository;
import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;

    public UserRepositoryImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public Set<UserDto> findAll() {
        return userJPARepository.findAll()
                .stream()
                .map(u -> new UserDto(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName()))
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto findById(String id) {
        User user = userJPARepository.findById(id).orElse(null);
        return (user != null) ? new UserDto(user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()) : null;
    }

    @Override
    public UserDto save(User object) {
        User user = userJPARepository.save(object);
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName());
    }

    @Override
    public void delete(User object) {
        userJPARepository.delete(object);
    }

    @Override
    public void deleteById(String id) {
        userJPARepository.deleteById(id);
    }

    @Override
    public UserDto update(String id, User newEntity) {
        User user = userJPARepository.findById(id).get();
        User newUser = userJPARepository.save(user.updateWith(newEntity));
        return new UserDto(newUser.getId(),
                newUser.getEmail(),
                newUser.getFirstName(),
                newUser.getLastName());
    }

    @Override
    public List<UserDto> findByRole(Role role) {
        return null;
    }

    @Override
    public List<UserDto> findByFirstName(String name) {
        return null;
    }
}
