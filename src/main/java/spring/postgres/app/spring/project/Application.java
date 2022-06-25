package spring.postgres.app.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.Status;
import spring.postgres.app.spring.project.entities.Type;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.SpidService;
import spring.postgres.app.spring.project.services.UserService;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    SpidService spidService;

    public static void main(String[] args)   {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        User igli = new User("Igli", "Koxha", "..", "Igli_Koxha", "lol", "iglikoxha@gmail.com");
        System.out.println(userService.createUser(igli));
        Spid spid = new Spid(igli, Status.PENDING, Type.LEVEL_1);
        System.out.println(spidService.createSpid(spid));
    }
}
