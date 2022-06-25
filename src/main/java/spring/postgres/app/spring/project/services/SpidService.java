package spring.postgres.app.spring.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.postgres.app.spring.project.Repository.SpidRepository;
import spring.postgres.app.spring.project.entities.Spid;

@Service
public class SpidService {
    @Autowired
    private SpidRepository repository;
}
