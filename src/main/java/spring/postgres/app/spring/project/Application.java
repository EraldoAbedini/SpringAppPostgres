package spring.postgres.app.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.Status;
import spring.postgres.app.spring.project.entities.Type;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.SpidService;
import spring.postgres.app.spring.project.services.UserService;

import java.sql.Timestamp;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    public UserService userService;
    @Autowired
    public SpidService spidService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new java.sql.Timestamp(time);
        User igli = new User(timestamp, "Admin", "Igli", "Koxha", "..", "Igli_Koxha", "lol", "iglikoxha@gmail.com");
        System.out.println(userService.createUser(igli));
        Spid spid = new Spid(timestamp, "Admin", igli, Status.PENDING, Type.LEVEL_2);
        System.out.println(spidService.createSpid(spid));
    }
}
