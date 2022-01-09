package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.UserJPARepository;
import co.perficient.university.exception.NullEntityException;
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
import java.util.stream.Collectors;

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
    public Set<UserDto> findAll() {
        return userJPARepository.findAll()
                .stream()
                .map(u -> new UserDto(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName()))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<UserDto> findById(String id) {
        UserDto userDto = userJPARepository.findById(id).map(u -> UserDto.builder()
                        .id(u.getId())
                        .lastName(u.getLastName())
                        .email(u.getEmail())
                        .firstName(u.getFirstName())
                        .build())
                .orElseThrow(() -> new NullEntityException("User not found"));

        return Optional.of(userDto);
    }

    @Override
    public Optional<UserDto> save(User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        User user = userJPARepository.save(object);

        return Optional.of(UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build());
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
    public Optional<UserDto> update(String id, User newEntity) {
        return userJPARepository.findById(id).map(s -> {
            User save = userJPARepository.save(s.updateWith(newEntity));
            return UserDto.builder()
                    .id(save.getId())
                    .email(save.getEmail())
                    .firstName(save.getFirstName())
                    .lastName(save.getLastName())
                    .build();
        });
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
