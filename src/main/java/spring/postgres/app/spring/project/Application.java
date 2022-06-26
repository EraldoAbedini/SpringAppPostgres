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

        User igli = new User(timestamp, "Admin", "Igli", "Koxha", "card14", "Igli_Koxha", "lol", "iglikoxha@gmail.com");
        User user1 = new User(timestamp, "Admin", "User1", "user1", "card24", "User_1", "user1password", "user1@gmail.com");
        User user2 = new User(timestamp, "Admin", "User1", "user2", "card34", "User_2", "user2password", "user2@gmail.com");

        System.out.println(userService.createUser(igli));
        System.out.println(userService.createUser(user1));
        System.out.println(userService.createUser(user2));

        Spid spid1 = new Spid(timestamp, "Admin", igli, Status.PENDING, Type.LEVEL_2);
        Spid spid2 = new Spid(timestamp, "Admin", user1, Status.PENDING, Type.LEVEL_2);
        Spid spid3 = new Spid(timestamp, "Admin", user2, Status.PENDING, Type.LEVEL_2);

        System.out.println(spidService.createSpid(spid1));
        System.out.println(spidService.createSpid(spid2));
        System.out.println(spidService.createSpid(spid3));
    }
}
