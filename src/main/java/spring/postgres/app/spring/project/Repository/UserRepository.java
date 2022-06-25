package spring.postgres.app.spring.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM spid WHERE id = : toFindId ",
            nativeQuery = true)
    public Spid searchSpid(long toFindId );

}