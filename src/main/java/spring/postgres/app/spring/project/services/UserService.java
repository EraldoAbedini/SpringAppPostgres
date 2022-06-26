package spring.postgres.app.spring.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.User;
import spring.postgres.app.spring.project.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;


@Service
public class UserService {
    long time = System.currentTimeMillis();
    Timestamp timestamp = new java.sql.Timestamp(time);
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long userId) {
        return userRepository.getReferenceById(userId);
    }

    public User editUser(long id, User user) {
        User updatedUser = userRepository.getReferenceById(id);
        updatedUser.setCreatedAt(timestamp);
        updatedUser.setCreatedBy(user.getCreatedBy());
        updatedUser.setName(user.getName());
        updatedUser.setCardNo(user.getCardNo());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        return userRepository.save(updatedUser);
    }


    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public User editUserName(long id, String name) {
        User userToBeEdited = userRepository.getReferenceById(id);
        userToBeEdited.setName(name);
        return userRepository.save(userToBeEdited);
    }

    public Spid searchSpid(long spidid) {
        return userRepository.searchSpid(spidid);
    }
}
