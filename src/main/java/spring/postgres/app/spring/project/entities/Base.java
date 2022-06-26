package spring.postgres.app.spring.project.entities;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Time;
import java.sql.Timestamp;


@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private java.sql.Timestamp createdAt;
    private String createdBy;

    public Base(Timestamp createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}
