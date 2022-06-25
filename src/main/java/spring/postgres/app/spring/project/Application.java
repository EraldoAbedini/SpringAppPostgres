package spring.postgres.app.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.SpidService;
import spring.postgres.app.spring.project.services.UserService;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {
    @Autowired
    UserService userService;
    SpidService spidService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.createUser(new User("Eraldo", "Abedin", "..", "Eraldo_Abedin", "lol", "abedinieraldo@gmail.com")));
    }
}
