package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.FakturaPozycja;;

public interface PozycjaRepository extends CrudRepository<FakturaPozycja, Long> {
    FakturaPozycja deleteById(Long id)throws ResourceNotFoundException;

}
