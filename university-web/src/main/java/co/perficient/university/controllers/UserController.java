package co.perficient.university.controllers;

import co.perficient.university.application.service.user.*;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/user/")
public class UserController {
    private final SaveUserApplicationService saveUserApplicationService;
    private final DeleteUserApplicationService deleteUserApplicationService;
    private final DeleteUserByIdApplicationService deleteUserByIdApplicationService;
    private final FindUserByIdApplicationService findUserByIdApplicationService;
    private final FindAllUsersApplicationService findAllUsersApplicationService;

    public UserController(SaveUserApplicationService saveUserApplicationService,
                          DeleteUserApplicationService deleteUserApplicationService,
                          DeleteUserByIdApplicationService deleteUserByIdApplicationService,
                          FindUserByIdApplicationService findUserByIdApplicationService,
                          FindAllUsersApplicationService findAllUsersApplicationService) {
        this.saveUserApplicationService = saveUserApplicationService;
        this.deleteUserApplicationService = deleteUserApplicationService;
        this.deleteUserByIdApplicationService = deleteUserByIdApplicationService;
        this.findUserByIdApplicationService = findUserByIdApplicationService;
        this.findAllUsersApplicationService = findAllUsersApplicationService;
    }

    @PostMapping
    public void save(@RequestBody User user) {
        saveUserApplicationService.run(user);
    }

    @GetMapping("/users")
    public Set<UserDto> findAll() {
        return findAllUsersApplicationService.run();
    }

    @GetMapping
    public User findById(@RequestParam(name = "id") String id) {
        return findUserByIdApplicationService.run(id);
    }

    @DeleteMapping("/user/{user}")
    public void delete(@RequestBody User user) {
        deleteUserApplicationService.run(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@RequestParam(name = "id") String id) {
        deleteUserByIdApplicationService.run(id);
    }

}
