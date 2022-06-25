package spring.postgres.app.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.UserService;


@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(userService.createUser(new User( "Igli", "Koxha", "..", "Igli_Koxha", "lol", "abedinieraldo@gmail.com")));
    }
}
