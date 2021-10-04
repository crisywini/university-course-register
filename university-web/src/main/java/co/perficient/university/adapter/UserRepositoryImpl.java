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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository, UserDetailsService {
    private final UserJPARepository userJPARepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("The user name was not found!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
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
        object.setPassword(passwordEncoder.encode(object.getPassword()));
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
        return userJPARepository.findByRole(role);
    }

    @Override
    public List<UserDto> findByFirstName(String name) {
        return userJPARepository.findByFirstName(name);
    }

    @Override
    public User findByEmail(String email) {
        Page<User> page = userJPARepository.findByEmail(email, PageRequest.of(0, 1));
        return page.stream().findFirst().orElse(null);
    }

}
