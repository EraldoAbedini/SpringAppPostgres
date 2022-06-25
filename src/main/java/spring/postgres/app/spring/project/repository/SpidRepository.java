package spring.postgres.app.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.postgres.app.spring.project.entities.Spid;

@Repository
public interface SpidRepository extends JpaRepository<Spid, Long> {


}