package spring.postgres.app.spring.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.services.UserService;

@SpringBootTest(classes = {Application.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void doesItCreateUser() {
        User albin = new User("Albin", "Mema", "..", "Albin_Mema", "haskell", "albinmema@gmail");
        userService.createUser(albin);
        Assertions.assertNotNull(userService.getUser(albin.getId()));
    }

}
