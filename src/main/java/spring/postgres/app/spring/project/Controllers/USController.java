package spring.postgres.app.spring.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.UserService;

@RestController
@RequestMapping(value = "/api")

public class USController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) User user) {
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }
}
