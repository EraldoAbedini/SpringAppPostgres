package spring.postgres.app.spring.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.postgres.app.spring.project.entities.Spid;
import spring.postgres.app.spring.project.entities.Status;
import spring.postgres.app.spring.project.repository.SpidRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpidService {
    @Autowired
    private SpidRepository repository;

    public Spid createSpid(Spid addnewspid) {
        return (addnewspid.getStatus().equals(Status.PENDING)) ? repository.save(addnewspid) : null;
    }

    public List<Spid> getAllSpids() {
        return repository.findAll();
    }

    public Spid getSpid(long id) {
        Optional<Spid> spid = repository.findById(id);
        return spid.orElse(null);
    }

    public void deleteSpid(long id) {
        Spid deleteSpid = repository.getReferenceById(id);
        repository.deleteById(id);
    }

    public Spid changeSpidStatus(long userId, long spidId) {
        Spid spidEditStatus = repository.getReferenceById(spidId);
        if (spidEditStatus.getUser().getId() == userId) {
            spidEditStatus.setStatus(Status.READY_FOR_REVIEW);
            return repository.save(spidEditStatus);
        }
        return null;
    }

}
