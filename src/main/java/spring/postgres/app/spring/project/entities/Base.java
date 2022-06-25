package spring.postgres.app.spring.project.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.security.Timestamp;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Timestamp createdAt;
    private String createdBy;

    public Base(Timestamp createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}
