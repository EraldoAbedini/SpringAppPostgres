package spring.postgres.app.spring.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.SpidService;
import spring.postgres.app.spring.project.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class USController {
    @Autowired
    private UserService userService;
    @Autowired
    private SpidService spidService;


    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/allspids")
    public ResponseEntity<Spid> getAllSpids() {
        return new ResponseEntity(spidService.getAllSpid(), HttpStatus.OK);
    }

    @DeleteMapping("spids/deletespid/id")
    public ResponseEntity<Spid> deleteSpid(@PathVariable long id){
        spidService.deleteSpid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
