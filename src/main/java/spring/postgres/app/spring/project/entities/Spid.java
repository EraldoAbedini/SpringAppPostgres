package spring.postgres.app.spring.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spid")
public class Spid extends Base {
    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Spid(Timestamp createdAt,
                String createdBy,
                User user,
                Status status,
                Type type
    ) {
        super(createdAt, createdBy);
        this.user = user;
        this.status = Status.PENDING;
        this.type = type;
    }
}
