package co.perficient.university.controllers;

import co.perficient.university.application.service.user.*;
import co.perficient.university.model.User;
import co.perficient.university.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final SaveUserApplicationService saveUserApplicationService;
    private final DeleteUserApplicationService deleteUserApplicationService;
    private final DeleteUserByIdApplicationService deleteUserByIdApplicationService;
    private final FindUserByIdApplicationService findUserByIdApplicationService;
    private final FindAllUsersApplicationService findAllUsersApplicationService;
    private final UpdateUserApplicationService updateUserApplicationService;

    public UserController(SaveUserApplicationService saveUserApplicationService,
                          DeleteUserApplicationService deleteUserApplicationService,
                          DeleteUserByIdApplicationService deleteUserByIdApplicationService,
                          FindUserByIdApplicationService findUserByIdApplicationService,
                          FindAllUsersApplicationService findAllUsersApplicationService,
                          UpdateUserApplicationService updateUserApplicationService) {
        this.saveUserApplicationService = saveUserApplicationService;
        this.deleteUserApplicationService = deleteUserApplicationService;
        this.deleteUserByIdApplicationService = deleteUserByIdApplicationService;
        this.findUserByIdApplicationService = findUserByIdApplicationService;
        this.findAllUsersApplicationService = findAllUsersApplicationService;
        this.updateUserApplicationService = updateUserApplicationService;
    }

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody User user) {
        saveUserApplicationService.run(user);
    }

    @GetMapping("/users")
    public Set<UserDto> findAll() {
        return findAllUsersApplicationService.run();
    }

    @GetMapping
    public UserDto findById(@RequestParam(name = "id") String id) {
        return findUserByIdApplicationService.run(id);
    }

    @DeleteMapping("/user")
    public void delete(@RequestBody User user) {
        deleteUserApplicationService.run(user);
    }

    @DeleteMapping
    public void deleteById(@RequestParam(name = "id") String id) {
        deleteUserByIdApplicationService.run(id);
    }


    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public UserDto update(@PathVariable String id,
                          @RequestBody User newUser) {
        return updateUserApplicationService.run(id, newUser);
    }

}
