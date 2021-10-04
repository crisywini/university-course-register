package co.perficient.university.controllers;

import co.perficient.university.application.service.user.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.util.Util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private final SaveUserApplicationService saveUserApplicationService;
    private final DeleteUserApplicationService deleteUserApplicationService;
    private final DeleteUserByIdApplicationService deleteUserByIdApplicationService;
    private final FindUserByIdApplicationService findUserByIdApplicationService;
    private final FindAllUsersApplicationService findAllUsersApplicationService;
    private final UpdateUserApplicationService updateUserApplicationService;
    private final FindUserByEmailApplicationService findUserByEmailApplicationService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody User user) {

        UserDto saved = null;
        try {
            saved = saveUserApplicationService.run(user);
        } catch (RepeatedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Set<UserDto>> findAll() {
        return new ResponseEntity<>(findAllUsersApplicationService.run(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserDto> findById(@RequestParam(name = "id") String id) {
        return new ResponseEntity<>(findUserByIdApplicationService.run(id), HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@RequestBody User user) {
        try {
            deleteUserApplicationService.run(user);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The user " + user.getId() + " was removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") String id) {
        try {
            deleteUserByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The user " + id + " was removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id,
                                    @RequestBody User newUser) {
        UserDto updated = null;
        try {
            updated = updateUserApplicationService.run(id, newUser);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Util.processAuthorizationToRefreshToken(request, response, findUserByEmailApplicationService);

    }

}
