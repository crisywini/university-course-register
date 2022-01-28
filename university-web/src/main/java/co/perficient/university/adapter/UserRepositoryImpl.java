package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.UserJPARepository;
import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.port.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository, UserDetailsService {

    private final UserJPARepository userJPARepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("The user name was not found!"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userJPARepository.findAll());
    }

    @Override
    public Optional<User> findById(String id) {
        return userJPARepository.findById(id);
    }

    @Override
    public Optional<User> save(User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return Optional.of(userJPARepository.save(object));
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
    public Optional<User> update(String id, User newEntity) {
        return userJPARepository.findById(id).map(s -> userJPARepository.save(s.updateWith(newEntity)));
    }

    @Override
    public List<UserDto> findByRole(Role role) {
        return userJPARepository.findByRole(role);
    }

    @Override
    public List<UserDto> findByFirstName(String name) {
        return userJPARepository.findByFirstName(name);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Page<User> page = userJPARepository.findByEmail(email, PageRequest.of(0, 1));
        return page.stream().findFirst();
    }

}
