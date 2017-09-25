package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import pl.connectis.cschool.jcourse.restservice.domain.Produkt;
import java.util.Optional;

public interface ProduktRepository extends CrudRepository<Produkt, Long>{
	Optional<Produkt> findByNazwa(String nazwa);
}
