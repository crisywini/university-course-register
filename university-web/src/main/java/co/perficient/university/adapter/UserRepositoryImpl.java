package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.UserJPARepository;
import co.perficient.university.model.User;
import co.perficient.university.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;

    public UserRepositoryImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userJPARepository.findAll());
    }

    @Override
    public User findById(String id) {
        return userJPARepository.findById(id).orElse(new User());
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
