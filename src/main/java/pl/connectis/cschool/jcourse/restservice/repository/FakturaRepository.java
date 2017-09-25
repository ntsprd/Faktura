package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.Faktura;

public interface FakturaRepository extends CrudRepository<Faktura, Long> {
    Faktura deleteById(long id) throws ResourceNotFoundException;
}
