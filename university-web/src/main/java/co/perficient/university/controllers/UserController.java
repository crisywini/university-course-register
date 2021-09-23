package co.perficient.university.controllers;

import co.perficient.university.application.service.user.*;
import co.perficient.university.model.Gender;
import co.perficient.university.model.MaritalStatus;
import co.perficient.university.model.Nationality;
import co.perficient.university.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

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
    public void save(@RequestBody Map<String, Object> json) {
        String firstName = getValue(json, "firstName");
        String lastName = getValue(json, "lastName");
        String email = getValue(json, "email");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateOfBirth = getValue(json, "dateOfBirth");
        LocalDate dob = LocalDate.parse(dateOfBirth, dateFormatter);
        Gender gender = Gender.valueOf(getValue(json, "gender"));
        Nationality nationality = Nationality.valueOf(getValue(json, "nationality"));
        MaritalStatus maritalStatus = MaritalStatus.valueOf(getValue(json, "maritalStatus"));
        User user = new User(firstName, lastName, email, dob,
                gender, nationality, maritalStatus);
        this.saveUserApplicationService.run(user);
    }


    private String getValue(Map<String, Object> json, String key) {
        return json.get(key).toString();
    }


}
