package co.perficient.university.controllers;

import co.perficient.university.application.service.user.*;
import co.perficient.university.exception.NullEntityException;
import co.perficient.university.exception.ParamNotFoundException;
import co.perficient.university.exception.RepeatedEntityException;
import co.perficient.university.model.Role;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import co.perficient.university.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {
    private final SaveUserApplicationService saveUserApplicationService;
    private final DeleteUserApplicationService deleteUserApplicationService;
    private final DeleteUserByIdApplicationService deleteUserByIdApplicationService;
    private final FindUserByIdApplicationService findUserByIdApplicationService;
    private final FindAllUsersApplicationService findAllUsersApplicationService;
    private final UpdateUserApplicationService updateUserApplicationService;
    private final FindUserByEmailApplicationService findUserByEmailApplicationService;
    private final FindUserByFirstNameApplicationService findUserByFirstNameApplicationService;
    private final FindUserByRoleApplicationService findUserByRoleApplicationService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody User user) {

        UserDto saved;
        try {
            saved = saveUserApplicationService.run(user);
        } catch (RepeatedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<UserDto>> findAll() {
        return new ResponseEntity<>(findAllUsersApplicationService.run(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(findUserByIdApplicationService.run(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDto>> findByFirstName(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>(findUserByFirstNameApplicationService.run("%" + name + "%"), HttpStatus.OK);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<?> findByRole(@PathVariable(name = "role") String role) {
        List<UserDto> users;
        try {
            users = findUserByRoleApplicationService.run(Role.of(role));
        } catch (ParamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody User user) {
        try {
            deleteUserApplicationService.run(user);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The user " + user.getId() + " was removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") String id) {
        try {
            deleteUserByIdApplicationService.run(id);
        } catch (NullEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = "The user " + id + " was removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id,
                                    @RequestBody User newUser) {
        UserDto updated;
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
