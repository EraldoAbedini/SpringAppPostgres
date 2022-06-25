package spring.postgres.app.spring.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.postgres.app.spring.project.Repository.UserRepository;
import spring.postgres.app.spring.project.entities.User;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(long userId) {
        return userRepository.getReferenceById(userId);
    }

    public User editUser(long id, String name, String surname, String cardNo, String username, String password, String email) {
        User userToBeEdited = userRepository.getReferenceById(id);
        userToBeEdited.setName(name);
        userToBeEdited.setSurname(surname);
        userToBeEdited.setCardNo(cardNo);
        userToBeEdited.setUsername(username);
        userToBeEdited.setPassword(password);
        userToBeEdited.setEmail(email);
        return userRepository.save(userToBeEdited);
    }

    public User editUserName(long id, String name) {
        User userToBeEdited = userRepository.getReferenceById(id);
        userToBeEdited.setName(name);
        return userRepository.save(userToBeEdited);
    }

}
