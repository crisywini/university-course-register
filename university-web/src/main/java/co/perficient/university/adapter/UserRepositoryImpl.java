package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.UserJPARepository;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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
    public User findById(String id) {
        return userJPARepository.findById(id).orElse(null);
    }

    @Override
    public User save(User object) {
        return userJPARepository.save(object);
    }

    @Override
    public void delete(User object) {
        userJPARepository.delete(object);
    }

    @Override
    public void deleteById(String id) {
        userJPARepository.deleteById(id);
    }
}
