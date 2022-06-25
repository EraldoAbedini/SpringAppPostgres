package spring.postgres.app.spring.project.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User extends Base {
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;

    public User(Timestamp createdAt,
                String createdBy,
                String name,
                String surname,
                String cardNo,
                String username,
                String password,
                String email
    ) {
        super(createdAt, createdBy);
        this.name = name;
        this.surname = surname;
        this.cardNo = cardNo;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
